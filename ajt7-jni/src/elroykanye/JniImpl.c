#include "elroykanye_Jni.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_elroykanye_Jni_print
    (JNIEnv *env, jobject obj) {
    printf("In a C function\n");
}