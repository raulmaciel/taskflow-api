package com.devraul.taskflow.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    TODO, IN_PROGRESS, DONE;
}
