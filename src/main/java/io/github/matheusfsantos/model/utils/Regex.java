package io.github.matheusfsantos.model.utils;

import java.util.regex.Pattern;

public class Regex {

    public Pattern REGEX_NAME = Pattern.compile("^[A-Za-zÀ-ÖØ-öø-ÿ]+(\\\\s[A-Za-zÀ-ÖØ-öø-ÿ]+)*$");

}
