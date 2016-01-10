Its Been Ages Backend
=====================

### How to build / run
```
mvn clean package
java -jar target/ItsBeenAges-1.0-SNAPSHOT.jar server ItsBeenAges.yaml
```

### Terminology

#### Contact
A `contact` is a contact on a `user`'s phone. These are your friends.

#### User
A `user` is a person using the app. They have a list of `contact` associated with them.

### API Documentation

#### Delete Contact
```
DELETE  https://api.neverland.io/v1/contacts/{id}
```
#### Get Contact
```
GET     https://api.neverland.io/v1/contacts/{id}
```

#### Create new contact
```
POST https://api.neverland.io/v1/contacts
{
    "firstName": "Sexually",
    "lastName": "Ambiguous",
    "visitFrequencySeconds": 86400
}
```

#### Get User
```
GET     https://api.neverland.io/v1/users/{phoneNumber}
```

#### Get User's Contacts
```
GET https://api.neverland.io/v1/users/{id}/contacts
```

#### Create User
```
POST    https://api.neverland.io/v1/users
{
    "firstName": "Sexually",
    "lastName": "Ambiguous",
    "phoneNumber": "1-212-222-2222"
}
```

#### Associate Contact with User
Send over an array of Contact Ids
```
POST    https://api.neverland.io/v1/users/{id}/associateContacts
[400, 401, 402, 404]
```
