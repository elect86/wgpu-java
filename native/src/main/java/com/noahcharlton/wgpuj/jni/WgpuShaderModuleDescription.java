package com.noahcharlton.wgpuj.jni;

import com.noahcharlton.wgpuj.WgpuJava;
import com.noahcharlton.wgpuj.util.WgpuJavaStruct;

import java.nio.ByteBuffer;

public class WgpuShaderModuleDescription extends WgpuJavaStruct {

    private final WgpuU32Array code;

    public WgpuShaderModuleDescription(byte[] data) {
        useDirectMemory();

        var buffer = ByteBuffer.allocateDirect(data.length).put(data).position(0);
        var length = data.length / 4;

        code = inner(new WgpuU32Array(buffer, length));
    }

    public long load(long device) {
        return WgpuJava.wgpuNative.wgpu_device_create_shader_module(device, this.getPointerTo());
    }
}
