package io.neverland.itsbeenages.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.hibernate.validator.constraints.NotEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = User.Builder.class)
public class User {
  private final long id;
  @NotEmpty private final String firstName;
  @NotEmpty private final String lastName;
  @NotEmpty private final String phoneNumber;

  public User(long id, String firstName, String lastName, String phoneNumber) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
  }

  public long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Builder setId(long id) {
      this.id = id;
      return this;
    }

    public Builder setFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder setLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public User build() {
      return new User(id, firstName, lastName, phoneNumber);
    }
  }
}
