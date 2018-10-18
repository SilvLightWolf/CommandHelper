package com.laytonsmith.core.events;

import com.laytonsmith.abstraction.enums.MCVersion;
import com.laytonsmith.core.Static;

/**
 * This class is an enum class that represents all the types of events that CH is aware of. The reason an enum is
 * required, is because events can more easily be sorted and found this way.
 *
 */
public enum Driver {

	/**
	 * Block events
	 */
	BLOCK_BREAK,
	BLOCK_BURN,
	BLOCK_CAN_BUILD,
	BLOCK_DISPENSE,
	BLOCK_DAMAGE,
	BLOCK_EXPLODE,
	BLOCK_GROW,
	BLOCK_IGNITE,
	BLOCK_PLACE,
	BLOCK_REDSTONE,
	BLOCK_FROM_TO,
	BLOCK_FADE,
	BREW,
	BREWING_STAND_FUEL,
	CAULDRON_LEVEL_CHANGE,
	FURNACE_BURN,
	FURNACE_EXTRACT,
	FURNACE_SMELT,
	LEAVES_DECAY,
	NOTE_PLAY,
	PISTON_EXTEND,
	PISTON_RETRACT,
	REDSTONE_CHANGED,
	SIGN_CHANGED,
	/**
	 * Entity events
	 */
	AREA_EFFECT_CLOUD_APPLY,
	CREATURE_SPAWN,
	CREEPER_POWER,
	ENDERDRAGON_CHANGE_PAHSE,
	ENTITY_AIR_CHANGE,
	ENTITY_BREED,
	ENTITY_CHANGE_BLOCK,
	ENTITY_CREATE_PORTAL,
	ENTITY_DAMAGE,
	ENTITY_DAMAGE_PLAYER,
	ENTITY_DEATH,
	ENTITY_ENTER_PORTAL,
	ENTITY_EXPLODE,
	ENTITY_INTERACT,
	ENTITY_REGAIN_HEALTH,
	ENTITY_RESURRECT,
	ENTITY_SHOOT_BOW,
	ENTITY_TAME,
	ENTITY_TELEPORT,
	ENTITY_TOGGLE_GLIDE,
	ENTITY_UNLEASH,
	ENTITY_PORTAL_TRAVEL,
	EXPLOSION_PRIME,
	FIREWORK_EXPLODE,
	HANGING_BREAK,
	HORSE_JUMP,
	ITEM_DROP,
	ITEM_PICKUP,
	ITEM_DESPAWN,
	ITEM_MERGE,
	ITEM_SPAWN,
	PIG_ZAP,
	POTION_SPLASH,
	PROJECTILE_HIT,
	PROJECTILE_LAUNCH,
	SHEEP_DYE_WOOL,
	SHEEP_REGROW_WOOL,
	SLIME_SPLIT,
	TARGET_ENTITY,
	VILLAGER_ACQUIRE_TRADE,
	VILLAGER_REPLENISH_TRADE,
	/**
	 * Inventory events
	 */
	INVENTORY_CLICK,
	INVENTORY_CLOSE,
	INVENTORY_DRAG,
	INVENTORY_OPEN,
	ITEM_ENCHANT,
	ITEM_HELD,
	ITEM_SWAP,
	ITEM_PRE_CRAFT,
	ITEM_PRE_ENCHANT,
	PRE_ANVIL,
	/**
	 * Player events
	 */
	BOOK_EDITED,
	CHANGED_MAIN_HAND,
	EGG_THROW,
	EXP_CHANGE,
	FOOD_LEVEL_CHANGED,
	GAMEMODE_CHANGE,
	ITEM_BREAK,
	ITEM_MEND,
	LOCALE_CHANGE,
	PLAYER_ADVANCEMENT_DONE,
	PLAYER_ANIMATION,
	PLAYER_BED_EVENT,
	PLAYER_BUCKET,
	PLAYER_CHANNEL,
	PLAYER_CHAT,
	PLAYER_COMMAND,
	PLAYER_CONSUME,
	PLAYER_DEATH,
	PLAYER_FISH,
	PLAYER_INTERACT,
	PLAYER_INTERACT_ENTITY,
	PLAYER_INTERACT_AT_ENTITY,
	PLAYER_JOIN,
	PLAYER_KICK,
	PLAYER_LOGIN,
	PLAYER_MOVE,
	PLAYER_PORTAL_TRAVEL,
	PLAYER_QUIT,
	PLAYER_RESOURCEPACK_STATUS,
	PLAYER_SPAWN,
	PLAYER_STATISTIC_INCREMENT,
	PLAYER_TOGGLE_FLIGHT,
	PLAYER_TOGGLE_SNEAK,
	PLAYER_TOGGLE_SPRINT,
	PLAYER_TELEPORT,
	PLAYER_VELOCITY,
	TAB_COMPLETE,
	WORLD_CHANGED,
	/**
	 * Plugin events
	 */
	PLUGIN_MESSAGE_RECEIVED,
	/**
	 * Server events
	 */
	SERVER_COMMAND,
	SERVER_PING,
	BROADCAST_MESSAGE,
	/**
	 * Vehicle events
	 */
	VEHICLE_COLLIDE,
	VEHICLE_ENTER,
	VEHICLE_LEAVE,
	VEHICLE_MOVE,
	VEHICLE_DESTROY,
	/**
	 * Weather events
	 */
	LIGHTNING_STRIKE,
	THUNDER_CHANGE,
	WEATHER_CHANGE,
	/**
	 * World events
	 */
	TREE_GROW,
	WORLD_LOAD,
	WORLD_UNLOAD,
	WORLD_SAVE,
	/**
	 * Cmdline events
	 */
	CMDLINE_PROMPT_INPUT,
	SHUTDOWN,
	/**
	 * Only Extends Event
	 */
	ASYNC_PLAYER_PRE_LOGIN,
	/**
	 * Extension events, used by events fired from the extension system.
	 */
	EXTENSION;

	MCVersion version;

	Driver() {
		version = MCVersion.MC1_0;
	}

	Driver(MCVersion added) {
		version = added;
	}

	public boolean existsInCurrent() {
		return Static.getServer().getMinecraftVersion().ordinal() >= version.ordinal();
	}
}
