package com.fakedevelopers.bidderbidder.dto;

import com.fakedevelopers.bidderbidder.model.UserEntity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * OAuth2UserRegisterDto: OAuth2 로그인시에 필요한 정보들을 정의.
 * <br>
 * #33 기준 필요한 정보: Email, nickname(nullable)
 */
@Builder
@Getter
@RequiredArgsConstructor
public class OAuth2UserRegisterDto {

  @NotBlank(message = "사용자ID는 공백문자가 포함될 수 없습니다")
  @Pattern(message = "사용자ID에는 영문자, 숫자, _만 포함 가능합니다", regexp = "[a-zA-Z0-9_]")
  private final String username;

  @Email(message = "이메일의 형식을 따라야 합니다.")
  @NotBlank(message = "이메일에는 공백문자가 포함될 수 없습니다")
  private final String email;

  @NotBlank(message = "형식이 잘못되었습니다.")
  @Length(min = 3, max = 12)
  private final String nickname;

  public UserEntity toUserEntity() {
    return UserEntity.builder()
        .username(username)
        .email(email)
        .nickname(nickname)
        .build();
  }
}
