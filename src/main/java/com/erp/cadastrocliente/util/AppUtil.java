package com.erp.cadastrocliente.util;

import java.util.Base64;
import org.springframework.web.multipart.MultipartFile;

public final class AppUtil {

  private AppUtil() {
    // Prevent instantiation
  }

  public static byte[] multipartFileToBinary(MultipartFile file) {
    try {
      return file.getBytes();
    } catch (Exception e) {
      throw new RuntimeException("Error converting MultipartFile to byte array", e);
    }
  }

  public static String binaryToBase64(byte[] binary) {
    return Base64.getEncoder().encodeToString(binary);
  }
}
