package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public final static class Constants
    {

        public static  final String SERVERNOTACCESSIBLEEXCEPTION = "Server is not accessible for now.";
        public static  final String UNAUTHORIZEDUSEREXCEPTION = "User is not authorized.";
        public static  final String BANNEDUSEREXCEPTION = "User is banned.";
        public static  final String RESTRICTIONEXCEPTION = "Access is denied.";
    }
    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.SERVERNOTACCESSIBLEEXCEPTION);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.SERVERNOTACCESSIBLEEXCEPTION, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.UNAUTHORIZEDUSEREXCEPTION);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.UNAUTHORIZEDUSEREXCEPTION, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.BANNEDUSEREXCEPTION);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.BANNEDUSEREXCEPTION, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.RESTRICTIONEXCEPTION);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.RESTRICTIONEXCEPTION, cause);
        }
    }
}
