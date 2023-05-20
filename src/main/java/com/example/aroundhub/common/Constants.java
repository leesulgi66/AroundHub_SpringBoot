package com.example.aroundhub.common;

public class Constants {

    public enum ExceptionClass {

        PRODUCT("Product"), ORDER("Order"), PROVIDER("Provider");

        private String excptionClass;

        ExceptionClass(String excptionClass) {
            this.excptionClass = excptionClass;
        }

        public String getExcptionClass() {
            return excptionClass;
        }

        @Override
        public String toString() {
            return getExcptionClass() + " Exception. ";
        }
    }
}
