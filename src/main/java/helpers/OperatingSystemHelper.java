package helpers;

public class OperatingSystemHelper {
     private static String OS = null;

     public static String getOsName()
     {
         if(OS == null) { OS = System.getProperty("os.name"); }
         return OS;
     }

     public static boolean isWindows()
     {
         return getOsName().startsWith("Windows");
     }

      public static boolean isMacOs()
      {
          return getOsName().startsWith("Mac");
      }

      public static boolean isLinux()
      {
          return getOsName().startsWith("Linux");
      }
}