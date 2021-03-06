package com.noahcharlton.wgpuj.util;

import com.noahcharlton.wgpuj.WgpuJava;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class WgpuJavaStruct extends Struct {

    public WgpuJavaStruct() {
        super(WgpuJava.getRuntime());
    }

    public WgpuJavaStruct(Runtime runtime) {
        super(runtime);
    }

    public void useDirectMemory(){
        int size = Struct.size(this);

        jnr.ffi.Pointer pointer = WgpuJava.getRuntime().getMemoryManager().allocateDirect(size);
        useMemory(pointer);
    }

    public jnr.ffi.Pointer getPointerTo(){
        return Struct.getMemory(this);
    }
}
