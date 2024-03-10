import java.util.HashMap;
import java.util.Map;

public class WeaponGenerator {

    // Format: name, dexterity, cost, hp, end, str, intel, fth
    public HashMap<String, Weapon> fillInventoryMap() {
        HashMap<String, Weapon> weaponMap = new HashMap<>();

        addWeapon(weaponMap, "Short Sword", 13, 1000, 0, 15, 15, 15, 15);
        addWeapon(weaponMap, "Rogier's Rapier", 18, 2000, 10, 25, 35, 35, 35);
        addWeapon(weaponMap, "Coded Sword", 21, 4000, 20, 35, 40, 40, 40);
        addWeapon(weaponMap, "Sword of Night and Flame", 25, 8000, 30, 45, 55, 55, 55);
        addWeapon(weaponMap, "Uchigatana", 15, 1875, 20, 35, 30, 0, 0);
        addWeapon(weaponMap, "Moonveil", 20, 3750, 30, 40, 45, 0, 0);
        addWeapon(weaponMap, "Rivers of Blood", 25, 7500, 40, 45, 60, 0, 0);
        addWeapon(weaponMap, "Hand of Malenia", 30, 15000, 50, 50, 75, 0, 0);
        addWeapon(weaponMap, "Whip", 20, 1500, 15, 60, 20, 0, 0);
        addWeapon(weaponMap, "Urumi", 25, 3000, 20, 70, 40, 10, 0);
        addWeapon(weaponMap, "Thorned Whip", 30, 5000, 30, 80, 50, 0, 40);
        addWeapon(weaponMap, "Hoslow's Petal Whip", 35, 10000, 35, 90, 55, 20, 20);
        addWeapon(weaponMap, "Claymore", 9, 3000, 15, 10, 20, 0, 0);
        addWeapon(weaponMap, "Starscourge Greatsword", 14, 6000, 20, 15, 40, 0, 20);
        addWeapon(weaponMap, "Inseparable Sword", 19, 12000, 25, 20, 70, 60, 60);
        addWeapon(weaponMap, "Maliketh's Black Blade", 24, 24000, 30, 25, 80, 40, 60);
        addWeapon(weaponMap, "Astrologer's Staff", 12, 2000, 5, 20, 5, 25, 15);
        addWeapon(weaponMap, "Albinauric Staff", 14, 4000, 10, 30, 10, 45, 35);
        addWeapon(weaponMap, "Staff of the Guilty", 16, 8000, 15, 40, 15, 65, 60);
        addWeapon(weaponMap, "Carian Regal Scepter", 18, 16000, 25, 50, 20, 85, 75);
        addWeapon(weaponMap, "Finger Seal", 10, 2500, 10, 45, 0, 15, 20);
        addWeapon(weaponMap, "Godslayer's Seal", 12, 5000, 15, 50, 0, 35, 40);
        addWeapon(weaponMap, "Golden Order Seal", 14, 10000, 20, 55, 0, 65, 65);
        addWeapon(weaponMap, "Dragon Communion Seal", 18, 15000, 25, 60, 0, 75, 80);

        return weaponMap;
    }

    private void addWeapon(Map<String, Weapon> weaponMap, String name, int dexterity, int cost, int hp, int end, int str, int intel, int fth) {
        Weapon weapon = new Weapon(name, dexterity, cost, hp, end, str, intel, fth);
        weaponMap.put(name, weapon);
    }
}
