package com.nocode.service;

import com.nocode.entity.UserEntity;
import com.nocode.pojo.User;
import com.nocode.repository.UserRepository;
import com.nocode.util.MapperUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.jcabi.aspects.Loggable;

@Service
@Loggable(prepend = true, logThis = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MapperUtilImpl mapperUtil;

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = mapperUtil.map(user, UserEntity.class);
        return mapperUtil.map(userRepository.save(userEntity), User.class);
    }

    @Override
    public List<User> getUsers() {
        Iterable<UserEntity> userEntities = userRepository.findAll();

        List<User> users = StreamSupport.stream(userEntities.spliterator(), true).map(userEntity -> mapperUtil.map(userEntity, User.class)).
            collect(Collectors.toList());

        return users;
    }

    @Override
    public User getUserById(Long id) {
        UserEntity persistedUser = userRepository.findById(id).orElseThrow(IllegalStateException::new);
        return mapperUtil.map(persistedUser, User.class);
    }

    @Override
    public User updateUser(Long id, User user) {
        UserEntity persistedUser = userRepository.findById(id).orElseThrow(IllegalAccessError::new);
        UserEntity updatedUser = mapperUtil.map(user, UserEntity.class);
        updatedUser.setId(persistedUser.getId());
        persistedUser = userRepository.save(updatedUser);
        return mapperUtil.map(updatedUser, User.class);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(userRepository.getById(id));
    }
}
