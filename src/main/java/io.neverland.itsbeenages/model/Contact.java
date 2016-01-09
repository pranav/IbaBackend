package io.neverland.itsbeenages.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.hibernate.validator.constraints.NotEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = Contact.Builder.class)
public class Contact {
  private final long id;
  @NotEmpty private final String firstName;
  @NotEmpty private final String lastName;
  @NotEmpty private final long visitFrequencySeconds;

  public Contact(long id, String firstName, String lastName, long visitFrequencySeconds) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.visitFrequencySeconds = visitFrequencySeconds;
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

  public long getVisitFrequencySeconds() {
    return visitFrequencySeconds;
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
    private long visitFrequencySeconds;

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

    public Builder setVisitFrequencySeconds(long visitFrequencySeconds) {
      this.visitFrequencySeconds = visitFrequencySeconds;
      return this;
    }

    public Contact build() {
      return new Contact(id, firstName, lastName, visitFrequencySeconds);
    }
  }
}
