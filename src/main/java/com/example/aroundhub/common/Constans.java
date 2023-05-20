package com.example.aroundhub.common;

public class Constans {

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
            return getExcptionClass() + "Exception. ";
        }
    }
}
