package com.thirdparty.defs.styles.units

import com.thirdparty.keys.DerivedStylePropBuilder

trait Calc[T[_]] extends DerivedStylePropBuilder[T] {

  /** Encode / sanitize value to put inside `url()` function */
  protected def encodeUrlValue(url: String): String

  /** Encode / sanitize value to put inside `calc()` function */
  protected def encodeCalcValue(exp: String): String

  /** Wrap the provided expression in CSS calc() function.
    *
    * @see https://developer.mozilla.org/en-US/docs/Web/CSS/calc()
    */
  lazy val calc: T[String] = derivedStyle(exp => s"calc(${encodeCalcValue(exp)})")
}
