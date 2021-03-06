package com.sksamuel.scrimage

import java.io.InputStream

import com.sksamuel.scrimage.nio.PngReader
import org.apache.commons.io.IOUtils

class FormatDetector {
  def detect(in: InputStream): Option[Format] = {
    if (PngReader.supports(IOUtils.toByteArray(in))) Some apply Format.PNG
    else None
  }
}

sealed trait Format
object Format {
  case object PNG extends Format
  case object GIF extends Format
  case object JPEG extends Format
}