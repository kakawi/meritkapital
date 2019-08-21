package com.hlebon.controller.dto.response;


import java.util.ArrayList;
import java.util.List;

public class ResponseDto {
    private List<Row> data = new ArrayList<>();

    public void addRow(Row row) {
        data.add(row);
    }

    public List<Row> getData() {
        return data;
    }

    public static class Row {
        private List<RowError> errors;

        public List<RowError> getErrors() {
            return errors;
        }

        public Row setErrors(List<RowError> errors) {
            this.errors = errors;
            return this;
        }

        public static class RowError {
            private final String message;

            public RowError(String message) {
                this.message = message;
            }

            public String getMessage() {
                return message;
            }
        }
    }
}
