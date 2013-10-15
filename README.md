# Shiva Persistence [![Build Status](https://aetheric.ci.cloudbees.com/buildStatus/icon?job=shiva-persist)](https://aetheric.ci.cloudbees.com/job/shiva-persist/)

This project aims to provide a useful framework for assisting with keeping persistence code neatly within a singular
module, thereby removing any and all database library dependencies from the rest of the project modules. The rest of an
application should only need to care about what it needs done to the data, not how to go about doing it.

This project is more of an exercise than a solution, as most of the work is in the implementation.

## Modules

### Shiva Persistence: API

This module provides the main set of interfaces and result objects.

### Shiva Persistence: Ebean Bindings

An abstract Ebean implementation of the primary API.
