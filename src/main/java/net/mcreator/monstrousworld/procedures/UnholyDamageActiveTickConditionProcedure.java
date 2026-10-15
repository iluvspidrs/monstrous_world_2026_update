package net.mcreator.monstrousworld.procedures;

public class UnholyDamageActiveTickConditionProcedure {
	public static boolean execute(double amplifier, double duration) {
		double baseRate = 0;
		double rateWithAmplifier = 0;
		baseRate = 30;
		rateWithAmplifier = baseRate / Math.pow(2, amplifier);
		if (Math.floor(rateWithAmplifier) > 0) {
			return duration % Math.floor(rateWithAmplifier) == 0;
		}
		return true;
	}
}