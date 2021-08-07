package me.nibo.springboot.jpa.web;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import me.nibo.springboot.jpa.dto.UserQueryParamDto;
import me.nibo.springboot.jpa.dto.UserRoleDto;
import me.nibo.springboot.jpa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户 Controller
 *
 * @author NiBo
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("roles")
  public ResponseEntity<List<UserRoleDto>> findUserRoleList(UserQueryParamDto queryParam) {
    List<UserRoleDto> list = userService.findUserRoleList(queryParam);
    if (CollectionUtils.isEmpty(list)) {
      UserRoleDto userRoleDto = new UserRoleDto();
      userRoleDto.setAge(25);
      userRoleDto.setUsername("张三");
      userRoleDto.setUserId("dwsdfsdf12222312");
      list.add(userRoleDto);
    }
    log.info("Hello");
    log.info("哈哈");
    return ResponseEntity.ok(list);
  }
}
