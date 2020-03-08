package com.calc.output;

class TextUpdaterExistsException extends Exception {
    private boolean instanceOfTextUpdaterExists;
    private TextUpdaterType updaterType;

    TextUpdaterExistsException(boolean instanceOfTextUpdaterExists, TextUpdaterType updaterType) {
        this.instanceOfTextUpdaterExists = instanceOfTextUpdaterExists;
        this.updaterType = updaterType;
    }

    @Override
    public String toString() {
        String message = instanceOfTextUpdaterExists ?
                getMessageWhenInstanceAlreadyExists() : getMessageWhenInstanceDoesNotExist();

        return message;
    }

    private String getMessageWhenInstanceAlreadyExists() {
        switch(updaterType) {
            case NUMERIC:
                return "Instance of NumericTextUpdater is already created";
            case OPERATOR:
                return "Instance of OperatorTextUpdater is already created";
            case CACHED:
                return "Instance of CachedTextUpdater is already created";
            default:
                return "unknown TextUpdater type";
        }
    }

    private String getMessageWhenInstanceDoesNotExist() {
        switch(updaterType) {
            case NUMERIC:
                return "Instance of NumericTextUpdater is not created";
            case OPERATOR:
                return "Instance of OperatorTextUpdater is not created";
            case CACHED:
                return "Instance of CachedTextUpdater is not created";
            default:
                return "unknown TextUpdater type";
        }
    }
}
