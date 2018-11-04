/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn (Confidential
 * Information). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.October.utilsdemo;
import org.apache.commons.lang3.SystemUtils;

/**
 * 了解SystemUtils可以拿到Java版本，操作系统
 *
 * @author sunyang
 * @date 2018/10/19 15:43
 */
public class SystemUtilsDemo {

    public static void main(String[] args) {

//            System.out.println(SystemUtils.OS_NAME_WINDOWS_PREFIX);
//            System.out.println(SystemUtils.USER_HOME_KEY);
//            System.out.println(SystemUtils.USER_DIR_KEY);
//            System.out.println(SystemUtils.JAVA_IO_TMPDIR_KEY);
//            System.out.println(SystemUtils.JAVA_HOME_KEY);
            System.out.println(SystemUtils.AWT_TOOLKIT);
            System.out.println(SystemUtils.FILE_ENCODING);
            System.out.println(SystemUtils.FILE_SEPARATOR);
            System.out.println(SystemUtils.JAVA_AWT_FONTS);
            System.out.println(SystemUtils.JAVA_AWT_GRAPHICSENV);
            System.out.println(SystemUtils.JAVA_AWT_HEADLESS);
            System.out.println(SystemUtils.JAVA_AWT_PRINTERJOB);
            System.out.println(SystemUtils.JAVA_CLASS_PATH);
            System.out.println(SystemUtils.JAVA_CLASS_VERSION);
            System.out.println(SystemUtils.JAVA_COMPILER);
            System.out.println(SystemUtils.JAVA_ENDORSED_DIRS);
            System.out.println(SystemUtils.JAVA_EXT_DIRS);
            System.out.println(SystemUtils.JAVA_HOME);
            System.out.println(SystemUtils.JAVA_IO_TMPDIR);
            System.out.println(SystemUtils.JAVA_LIBRARY_PATH);
            System.out.println(SystemUtils.JAVA_RUNTIME_NAME);
            System.out.println(SystemUtils.JAVA_RUNTIME_VERSION);
            System.out.println(SystemUtils.JAVA_SPECIFICATION_NAME);
            System.out.println(SystemUtils.JAVA_SPECIFICATION_VENDOR);
            System.out.println(SystemUtils.JAVA_SPECIFICATION_VERSION);
//            System.out.println(SystemUtils.JAVA_SPECIFICATION_VERSION_AS_ENUM);
            System.out.println(SystemUtils.JAVA_UTIL_PREFS_PREFERENCES_FACTORY);
            System.out.println(SystemUtils.JAVA_VENDOR);
            System.out.println(SystemUtils.JAVA_VENDOR_URL);
            System.out.println(SystemUtils.JAVA_VERSION);
            System.out.println(SystemUtils.JAVA_VM_INFO);
            System.out.println(SystemUtils.JAVA_VM_NAME);
            System.out.println(SystemUtils.JAVA_VM_SPECIFICATION_NAME);
            System.out.println(SystemUtils.JAVA_VM_SPECIFICATION_VENDOR);
            System.out.println(SystemUtils.JAVA_VM_SPECIFICATION_VERSION);
            System.out.println(SystemUtils.JAVA_VM_VENDOR);
            System.out.println(SystemUtils.JAVA_VM_VERSION);
            System.out.println(SystemUtils.LINE_SEPARATOR);
            System.out.println(SystemUtils.OS_ARCH);
            System.out.println(SystemUtils.OS_NAME);
            System.out.println(SystemUtils.OS_VERSION);
            System.out.println(SystemUtils.PATH_SEPARATOR);
            System.out.println(SystemUtils.USER_COUNTRY);
            System.out.println(SystemUtils.USER_DIR);
            System.out.println(SystemUtils.USER_HOME);
            System.out.println(SystemUtils.USER_LANGUAGE);
            System.out.println(SystemUtils.USER_NAME);
            System.out.println(SystemUtils.USER_TIMEZONE);
            System.out.println(SystemUtils.IS_JAVA_1_1);
            System.out.println(SystemUtils.IS_JAVA_1_2);
            System.out.println(SystemUtils.IS_JAVA_1_3);
            System.out.println(SystemUtils.IS_JAVA_1_4);
            System.out.println(SystemUtils.IS_JAVA_1_5);
            System.out.println(SystemUtils.IS_JAVA_1_6);
            System.out.println(SystemUtils.IS_JAVA_1_7);
            System.out.println(SystemUtils.IS_JAVA_1_8);
            System.out.println(SystemUtils.IS_JAVA_1_9);
            System.out.println(SystemUtils.IS_OS_AIX);
            System.out.println(SystemUtils.IS_OS_HP_UX);
            System.out.println(SystemUtils.IS_OS_400);
            System.out.println(SystemUtils.IS_OS_IRIX);
            System.out.println(SystemUtils.IS_OS_LINUX);
            System.out.println(SystemUtils.IS_OS_MAC);
            System.out.println(SystemUtils.IS_OS_MAC_OSX);
            System.out.println(SystemUtils.IS_OS_MAC_OSX_CHEETAH);
            System.out.println(SystemUtils.IS_OS_MAC_OSX_PUMA);
            System.out.println(SystemUtils.IS_OS_MAC_OSX_JAGUAR);
            System.out.println(SystemUtils.IS_OS_MAC_OSX_PANTHER);
            System.out.println(SystemUtils.IS_OS_MAC_OSX_TIGER);
            System.out.println(SystemUtils.IS_OS_MAC_OSX_LEOPARD);
            System.out.println(SystemUtils.IS_OS_MAC_OSX_SNOW_LEOPARD);
            System.out.println(SystemUtils.IS_OS_MAC_OSX_LION);
            System.out.println(SystemUtils.IS_OS_MAC_OSX_MOUNTAIN_LION);
            System.out.println(SystemUtils.IS_OS_MAC_OSX_MAVERICKS);
            System.out.println(SystemUtils.IS_OS_MAC_OSX_YOSEMITE);
            System.out.println(SystemUtils.IS_OS_FREE_BSD);
            System.out.println(SystemUtils.IS_OS_OPEN_BSD);
            System.out.println(SystemUtils.IS_OS_NET_BSD);
            System.out.println(SystemUtils.IS_OS_OS2);
            System.out.println(SystemUtils.IS_OS_SOLARIS);
            System.out.println(SystemUtils.IS_OS_SUN_OS);
            System.out.println(SystemUtils.IS_OS_UNIX);
            System.out.println(SystemUtils.IS_OS_WINDOWS);
            System.out.println(SystemUtils.IS_OS_WINDOWS_2000);
            System.out.println(SystemUtils.IS_OS_WINDOWS_2003);
            System.out.println(SystemUtils.IS_OS_WINDOWS_2008);
            System.out.println(SystemUtils.IS_OS_WINDOWS_2012);
            System.out.println(SystemUtils.IS_OS_WINDOWS_95);
            System.out.println(SystemUtils.IS_OS_WINDOWS_98);
            System.out.println(SystemUtils.IS_OS_WINDOWS_ME);
            System.out.println(SystemUtils.IS_OS_WINDOWS_NT);
            System.out.println(SystemUtils.IS_OS_WINDOWS_XP);
            System.out.println(SystemUtils.IS_OS_WINDOWS_VISTA);
            System.out.println(SystemUtils.IS_OS_WINDOWS_7);
            System.out.println(SystemUtils.IS_OS_WINDOWS_8);




    }
}

