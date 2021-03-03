# UNIT-TRANSFORMER

Unit transformer is an Java plugin to transform values between different units

## Methods to call
This plugin has the following functions:

<pre>UnitTransformer.transform(Enum unit, Enum targetUnit)</pre>
return value - double
unit - unit of the value to be transformed<br>
targetUnit - target unit of the transformed value<br><br>

<pre>UnitTransformer.transform(Enum unit, Enum targetUnit, String pattern)</pre>
same functionality as the first method, but it converts to the specified pattern<br>
return value - String<br>
pattern - converts to DecimalFormat pattern (like "#.##")

## Transformation between different enum types
You can transform between two different EnumUnits if the same value is defined in both enums

Example: You can transform between DataBinaryUnit, DataByteUnit, SIDataBinaryUnit, SIDataByteUnit, because they all have BIT as common value.

Otherwise an IllegalArgumentException will be thrown with the message "could not find units with same type between following two enums".

## Adding new units by your own
You can also add units yourself.

define an enum and implement the interface Unitizer for it
- sort your units from the lowest to the highest value
- the multiplier from this value you edit will be multiplied/divided by the next higher unit

## Transform units
In the latest version you can transform the following units

- Data storage
- length
- mass

more coming