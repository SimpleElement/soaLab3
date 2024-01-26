package org.example.remote;

import java.io.Serializable;

public class ResponseRemote implements Serializable {
    private int Status;
    private String message;

    public ResponseRemote(int status, String message) {
        Status = status;
        this.message = message;
    }

    public int getStatus() {
        return Status;
    }

    public String getMessage() {
        return message;
    }
}
