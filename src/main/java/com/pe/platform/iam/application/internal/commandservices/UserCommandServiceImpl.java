package com.pe.platform.iam.application.internal.commandservices;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import com.pe.platform.iam.application.internal.outboundservices.hashing.HashingService;
import com.pe.platform.iam.application.internal.outboundservices.tokens.TokenService;
import com.pe.platform.iam.domain.model.aggregates.User;
import com.pe.platform.iam.domain.model.commands.SignInCommand;
import com.pe.platform.iam.domain.model.commands.SignUpCommand;
import com.pe.platform.iam.domain.model.valueobjects.Roles;
import com.pe.platform.iam.domain.services.UserCommandService;
import com.pe.platform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.pe.platform.iam.infrastructure.persistence.jpa.repositories.UserRepository;

import java.util.Optional;

/**
 * User command service implementation
 * <p>
 *     This class implements the {@link UserCommandService} interface and provides the implementation for the
 *     {@link SignInCommand} and {@link SignUpCommand} commands.
 * </p>
 */
@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;
    private final RoleRepository roleRepository;

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService, TokenService tokenService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
        this.roleRepository = roleRepository;
    }

    /**
     * Handle the sign-up command
     * <p>
     *     This method handles the {@link SignUpCommand} command and returns the user.
     * </p>
     * @param command the sign-up command containing the username and password
     * @return the created user
     */
    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByUsername(command.username()))
            return Optional.empty(); // Devuelve un Optional vacío si el nombre de usuario ya existe

        var roles = command.roles();
        if (roles.isEmpty()) {
                var role = roleRepository.findByName(Roles.ROLE_STUDENT);
            if (role.isPresent()) roles.add(role.get());
        } else {
            roles = roles.stream().map(role -> {
                var existingRole = roleRepository.findByName(role.getName());
                return existingRole.orElseGet(() -> roleRepository.save(role)); // Crea el rol si no existe
            }).toList();
        }

        var user = new User(command.username(), hashingService.encode(command.password()), roles);
        userRepository.save(user);
        return userRepository.findByUsername(command.username());
    }

    /**
     * Handle the sign-in command
     * <p>
     *     This method handles the {@link SignInCommand} command and returns the user and the token.
     * </p>
     * @param command the sign-in command containing the username and password
     * @return and optional containing the user matching the username and the generated token
     * @throws RuntimeException if the user is not found or the password is invalid
     */
    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByUsername(command.username());
        if (user.isEmpty()) throw new RuntimeException("User not found");
        if (!hashingService.matches(command.password(), user.get().getPassword()))
            throw new RuntimeException("Invalid password");
        var token = tokenService.generateToken(user.get().getUsername());
        return Optional.of(ImmutablePair.of(user.get(), token));
    }
}