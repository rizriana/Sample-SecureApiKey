# Sample for my securing API using NDK
- Install NDK from your SDK Tools android studio.
- Create directory <b>jni</b> under the <b><i>app/src/main</i></b>.
- in the <b>jni</b> directory, create a file <b>Android.mk</b> and add this code to it :
```
LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := keys
LOCAL_SRC_FILES := keys.c

include $(BUILD_SHARED_LIBRARY)
```
- Create another file inside the <b>jni</b> directory named <b>Application.mk</b> and add this code.
```
APP_ABI := all
```
- Create the C/C++ file <b>keys.c</b> inside <b>jni</b> and add this code.
```
#include <jni.h>
JNIEXPORT jstring JNICALL
Java_id_rrlab_myapplication_MainActivity_getApiKey(JNIEnv *env, jobject instance) {
  return (*env)->  NewStringUTF(env, "YOUR_API_KEY");
}
```
- One more things, don't forget to add this below code to <b>build.gradle</b> file
```
android {
    .....
    buildTypes {
        .....
    }
    externalNativeBuild {
        ndkBuild {
            path 'src/main/jni/Android.mk'
        }
    }
}
```

### Load the code
- Call this method
```
init {
        System.loadLibrary("key")
}
```
- Declare a kotlin external function
```
external fun getAPIKey(): String
```
- Get the API by calling
```
getAPIKey()
```
