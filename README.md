# [NGSI v2](https://fiware.github.io/specifications/ngsiv2/stable/) SDK for Java

## Documentation for API Endpoints

All URIs are relative to *http://localhost:1026/v2*

Class | Method | HTTP request
------------ | ------------- | -------------
ApiEntryPointApi | retrieveApiResources | **GET** /
AttributeValueApi | getAttributeValue | **GET** /entities/{entityId}/attrs/{attrName}/value
AttributeValueApi | updateAttributeValue | **PUT** /entities/{entityId}/attrs/{attrName}/value
AttributesApi | getAttributeData | **GET** /entities/{entityId}/attrs/{attrName}
AttributesApi | removeASingleAttribute | **DELETE** /entities/{entityId}/attrs/{attrName}
AttributesApi | updateAttributeData | **PUT** /entities/{entityId}/attrs/{attrName}
BatchOperationsApi | notify | **POST** /op/notify
BatchOperationsApi | query | **POST** /op/query
BatchOperationsApi | update | **POST** /op/update
EntitiesApi | createEntity | **POST** /entities
EntitiesApi | listEntities | **GET** /entities
EntitiesApi | removeEntity | **DELETE** /entities/{entityId}
EntitiesApi | replaceAllEntityAttributes | **PUT** /entities/{entityId}/attrs
EntitiesApi | retrieveEntity | **GET** /entities/{entityId}
EntitiesApi | retrieveEntityAttributes | **GET** /entities/{entityId}/attrs
EntitiesApi | updateExistingEntityAttributes | **PATCH** /entities/{entityId}/attrs
EntitiesApi | updateOrAppendEntityAttributes | **POST** /entities/{entityId}/attrs
RegistrationsApi | createRegistration | **POST** /registrations
RegistrationsApi | deleteRegistration | **DELETE** /registrations/{registrationId}
RegistrationsApi | listRegistrations | **GET** /registrations
RegistrationsApi | retrieveRegistration | **GET** /registrations/{registrationId}
RegistrationsApi | updateRegistration | **PATCH** /registrations/{registrationId}
SubscriptionsApi | createSubscription | **POST** /subscriptions
SubscriptionsApi | deleteSubscription | **DELETE** /subscriptions/{subscriptionId}
SubscriptionsApi | listSubscriptions | **GET** /subscriptions
SubscriptionsApi | retrieveSubscription | **GET** /subscriptions/{subscriptionId}
SubscriptionsApi | updateSubscription | **PATCH** /subscriptions/{subscriptionId}
TypesApi | listEntityTypes | **GET** /types
TypesApi | retrieveEntityType | **GET** /types/{entityType}

## Known Issues
* **PATCH** /registrations/{registrationId} returns **405 Method Not Allowed**.<br/>
According to the [NGSIv2 Implementation Notes](https://github.com/telefonicaid/fiware-orion/blob/master/doc/manuals/user/ngsiv2_implementation_notes.md#registrations):<br/>
`PATCH /v2/registration/<id>` is not implemented. Thus, registrations cannot be updated directly. I.e., updates must be done deleting and re-creating the registration. Please see [this issue](https://github.com/telefonicaid/fiware-orion/issues/3007) about this.
* **204 No Content** responses cause `java.io.IOException: unexpected content length header with 204 response`<br/>
[This bug](https://bugs.openjdk.java.net/browse/JDK-8218662) has been fixed in jdk-11.0.7

## Additional Resources
* An introductory tutorial to the FIWARE Platform can be found [here](https://github.com/FIWARE/tutorials.Getting-Started).
* The official docker image of the Orion Context Broker can be found [here](https://hub.docker.com/r/fiware/orion).
