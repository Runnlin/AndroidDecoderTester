// CustomAIDL.aidl
package io.github.runnlin.decoder_tester;

// Declare any non-default types here with import statements

interface CustomAIDL {

//    String getStr();

    String getDecoders(int type);

    String checkDecoders(String decoders);
}