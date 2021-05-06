#include <jni.h>
JNIEXPORT jstring JNICALL
Java_id_rrlab_samplesecureapikey_MainActivity_apiKey(JNIEnv *env, jobject instance) {
  return (*env)->  NewStringUTF(env, "YOUR_API_KEY");
}