package com.laytonsmith.abstraction.bukkit.events.drivers;

import com.laytonsmith.abstraction.MCLocation;
import com.laytonsmith.abstraction.bukkit.BukkitMCLocation;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCExpChangeEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCFoodLevelChangeEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCGamemodeChangeEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerBedEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerChatEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerEditBookEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerFishEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerInteractEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerItemConsumeEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerJoinEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerKickEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerLoginEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerMoveEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerPortalEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerQuitEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerRespawnEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerTeleportEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerToggleFlightEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerToggleSneakEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerToggleSprintEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCWorldChangedEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCAsyncPrePlayerLogin;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCChangedMainHandEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCEggThrowEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCItemBreakEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCItemMendEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCLocaleChangeEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerAdvancementDoneEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerAnimationEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerBucketFillEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerBucketEmptyEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerResourcepackStatusEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerStatisticIncrementEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerVelocityEvent;
import com.laytonsmith.abstraction.bukkit.events.BukkitPlayerEvents.BukkitMCPlayerChannelEvent;
import com.laytonsmith.commandhelper.CommandHelperPlugin;
import com.laytonsmith.core.events.Driver;
import com.laytonsmith.core.events.EventUtils;
import com.laytonsmith.core.events.drivers.PlayerEvents;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerChangedMainHandEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerChannelEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemMendEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLocaleChangeEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRegisterChannelEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.event.player.PlayerUnregisterChannelEvent;
import org.bukkit.event.player.PlayerVelocityEvent;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BukkitPlayerListener implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public void onFoodLevelChange(FoodLevelChangeEvent e) {
		BukkitMCFoodLevelChangeEvent pke = new BukkitMCFoodLevelChangeEvent(e);
		EventUtils.TriggerListener(Driver.FOOD_LEVEL_CHANGED, "food_level_changed", pke);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerKick(PlayerKickEvent e) {
		BukkitMCPlayerKickEvent pke = new BukkitMCPlayerKickEvent(e);
		EventUtils.TriggerListener(Driver.PLAYER_KICK, "player_kick", pke);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerBedEnter(PlayerBedEnterEvent e) {
		BukkitMCPlayerBedEvent be = new BukkitMCPlayerBedEvent(e);
		EventUtils.TriggerListener(Driver.PLAYER_BED_EVENT, "player_enter_bed", be);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerBedLeave(PlayerBedLeaveEvent e) {
		BukkitMCPlayerBedEvent be = new BukkitMCPlayerBedEvent(e);
		EventUtils.TriggerListener(Driver.PLAYER_BED_EVENT, "player_leave_bed", be);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerLogin(PlayerLoginEvent e) {
		BukkitMCPlayerLoginEvent ple = new BukkitMCPlayerLoginEvent(e);
		EventUtils.TriggerListener(Driver.PLAYER_LOGIN, "player_login", ple);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerJoin(PlayerJoinEvent e) {
		BukkitMCPlayerJoinEvent pje = new BukkitMCPlayerJoinEvent(e);
		EventUtils.TriggerListener(Driver.PLAYER_JOIN, "player_join", pje);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerInteract(PlayerInteractEvent e) {
		BukkitMCPlayerInteractEvent pie = new BukkitMCPlayerInteractEvent(e);
		if(e.getAction().equals(Action.PHYSICAL)) {
			EventUtils.TriggerListener(Driver.PLAYER_INTERACT, "pressure_plate_activated", pie);
		} else {
			EventUtils.TriggerListener(Driver.PLAYER_INTERACT, "player_interact", pie);
		}
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		BukkitMCPlayerRespawnEvent pre = new BukkitMCPlayerRespawnEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_SPAWN, "player_spawn", pre);
	}

	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
	public void onPlayerChat(final AsyncPlayerChatEvent event) {
		if(CommandHelperPlugin.self.interpreterListener.isInInterpreterMode(event.getPlayer().getName())) {
			//They are in interpreter mode, so we want it to handle this, not everything else.
			return;
		}

		if(event.isAsynchronous()) {
			//The async event gets priority, and if cancelled, doesn't trigger a normal player_chat event.
			BukkitMCPlayerChatEvent pce = new BukkitMCPlayerChatEvent(event);
			EventUtils.TriggerListener(Driver.PLAYER_CHAT, "async_player_chat", pce);
			if(event.isCancelled()) {
				return;
			}
		}

		if(EventUtils.GetEvents(Driver.PLAYER_CHAT) != null && !EventUtils.GetEvents(Driver.PLAYER_CHAT).isEmpty()) {
			if(event.isAsynchronous()) {
				//We have to do the full processing on the main server thread, and
				//block on it as well, so if we cancel it or something, the change
				//will actually take effect. The easiest way to do this is to cancel the
				//chat event, then re-run it on the main server thread. Since we're
				//registering on lowest, this will hopefully not cause any problems,
				//but if it does, tough. Barring play-dirty mode, there's not a whole
				//lot that can be done reasonably.

//				SortedSet<BoundEvent> events = EventUtils.GetEvents(Driver.PLAYER_CHAT);
//				Event driver = EventList.getEvent(Driver.PLAYER_CHAT, "player_chat");
//				//Unfortunately, due to priority issues, if any event is syncronous, all of them
//				//have to be synchronous.
//				boolean canBeAsync = true;
//				boolean actuallyNeedToFire = false;
//				//If all the events are asynchronous, we can just run it as is.
//				for(BoundEvent b : events){
//					//We can't just use isSync here, because cancel and modify event,
//					//normally synchronous, aren't in this case, so we need to manually
//					//check the full function list.
//					for(Function f : b.getParseTree().getFunctions()){
//						if(f instanceof EventBinding.cancel || f instanceof EventBinding.modify_event){
//							continue;
//						}
//						if(f.runAsync() != null && f.runAsync() == false){
//							//Nope, can't be run async :(
//							canBeAsync = false;
//						}
//					}
//					try {
//						if(driver.matches(b.getPrefilter(), new BukkitPlayerEvents.BukkitMCPlayerChatEvent(event))){
//							//Yeah, we need to fire it, so we have to continue
//							actuallyNeedToFire = true;
//						}
//					} catch (PrefilterNonMatchException ex) {
//						//No need to fire this one
//					}
//				}
//
//				if(!actuallyNeedToFire){
//					//Yay! Prefilters finally actually optimized something!
//					return;
//				}
				//Until there is a more reliable way to detect isConst() on a parse tree, (that supports procs)
				//this must always be synchronous.
				boolean canBeAsync = false;
				if(canBeAsync) {
					//Fire away!
					fireChat(event);
				} else {
					final AsyncPlayerChatEvent copy = new AsyncPlayerChatEvent(false, event.getPlayer(), event.getMessage(), event.getRecipients());
					copy.setFormat(event.getFormat());
					//event.setCancelled(true);
					Future f = Bukkit.getServer().getScheduler().callSyncMethod(CommandHelperPlugin.self, new Callable() {
						@Override
						public Object call() throws Exception {
							onPlayerChat(copy);
							return null;
						}
					});
					while(true) {
						try {
							f.get();
							break;
						} catch (InterruptedException ex) {
							//I don't know why this happens, but screw it, we're gonna try again, and it's gonna like it.
						} catch (ExecutionException ex) {
							Logger.getLogger(BukkitPlayerListener.class.getName()).log(Level.SEVERE, null, ex);
							break;
						}
					}
					event.setCancelled(copy.isCancelled());
					event.setMessage(copy.getMessage());
					event.setFormat(copy.getFormat());
				}

			} else {
				fireChat(event);
			}
		}
	}

	private void fireChat(AsyncPlayerChatEvent event) {
		BukkitMCPlayerChatEvent pce = new BukkitMCPlayerChatEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_CHAT, "player_chat", pce);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerQuit(PlayerQuitEvent event) {
		BukkitMCPlayerQuitEvent pqe = new BukkitMCPlayerQuitEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_QUIT, "player_quit", pqe);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {
		if(event.getFrom().equals(event.getPlayer().getWorld())) {
			return;
		}

		BukkitMCWorldChangedEvent wce = new BukkitMCWorldChangedEvent(event);
		EventUtils.TriggerListener(Driver.WORLD_CHANGED, "world_changed", wce);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerTeleport(PlayerTeleportEvent event) {
		if(event.getFrom().equals(event.getTo())) {
			return;
		}

		BukkitMCPlayerTeleportEvent pte = new BukkitMCPlayerTeleportEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_TELEPORT, "player_teleport", pte);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPortalEnter(PlayerPortalEvent event) {
		BukkitMCPlayerPortalEvent pe = new BukkitMCPlayerPortalEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_PORTAL_TRAVEL, "player_portal_travel", pe);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onConsume(PlayerItemConsumeEvent event) {
		BukkitMCPlayerItemConsumeEvent pic = new BukkitMCPlayerItemConsumeEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_CONSUME, "player_consume", pic);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onFish(PlayerFishEvent event) {
		BukkitMCPlayerFishEvent fish = new BukkitMCPlayerFishEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_FISH, "player_fish", fish);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onGamemodeChange(PlayerGameModeChangeEvent event) {
		BukkitMCGamemodeChangeEvent e = new BukkitMCGamemodeChangeEvent(event);
		EventUtils.TriggerListener(Driver.GAMEMODE_CHANGE, "gamemode_change", e);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onExpChange(PlayerExpChangeEvent event) {
		BukkitMCExpChangeEvent e = new BukkitMCExpChangeEvent(event);
		EventUtils.TriggerListener(Driver.EXP_CHANGE, "exp_change", e);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerEditBook(PlayerEditBookEvent event) {
		BukkitMCPlayerEditBookEvent pebe = new BukkitMCPlayerEditBookEvent(event);
		EventUtils.TriggerListener(Driver.BOOK_EDITED, "book_edited", pebe);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
		BukkitMCPlayerToggleFlightEvent ptfe = new BukkitMCPlayerToggleFlightEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_TOGGLE_FLIGHT, "player_toggle_flight", ptfe);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
		BukkitMCPlayerToggleSneakEvent ptse = new BukkitMCPlayerToggleSneakEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_TOGGLE_SNEAK, "player_toggle_sneak", ptse);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerToggleSprint(PlayerToggleSprintEvent event) {
		BukkitMCPlayerToggleSprintEvent ptse = new BukkitMCPlayerToggleSprintEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_TOGGLE_SPRINT, "player_toggle_sprint", ptse);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerMove(PlayerMoveEvent event) {
		Location from = event.getFrom();
		Location to = event.getTo();
		if(from.getX() == to.getX() && from.getY() == to.getY() && from.getZ() == to.getZ()) {
			return;
		}
		String p = event.getPlayer().getName();
		for(Integer threshold : PlayerEvents.GetThresholdList()) {
			Map<String, MCLocation> lastLocations = PlayerEvents.GetLastLocations(threshold);
			MCLocation last;
			if(!lastLocations.containsKey(p)) {
				last = new BukkitMCLocation(from);
				lastLocations.put(p, last);
			} else {
				last = lastLocations.get(p);
			}
			MCLocation movedTo = new BukkitMCLocation(to);
			if(!movedTo.getWorld().getName().equals(last.getWorld().getName())) {
				lastLocations.put(p, movedTo);
				continue;
			}
			if(last.distance(movedTo) > threshold) {
				BukkitMCPlayerMoveEvent pme = new BukkitMCPlayerMoveEvent(event, threshold, last);
				EventUtils.TriggerListener(Driver.PLAYER_MOVE, "player_move", pme);
				if(!pme.isCancelled()) {
					lastLocations.put(p, movedTo);
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
		BukkitMCAsyncPrePlayerLogin appl = new BukkitMCAsyncPrePlayerLogin(event);
		EventUtils.TriggerListener(Driver.ASYNC_PLAYER_PRE_LOGIN, "async_player_pre_login", appl);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onChangedMainHand(PlayerChangedMainHandEvent event) {
		BukkitMCChangedMainHandEvent pcmhe = new BukkitMCChangedMainHandEvent(event);
		EventUtils.TriggerListener(Driver.CHANGED_MAIN_HAND, "changed_main_hand", pcmhe);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onEggThrow(PlayerEggThrowEvent event) {
		BukkitMCEggThrowEvent ete = new BukkitMCEggThrowEvent(event);
		EventUtils.TriggerListener(Driver.EGG_THROW, "egg_throw", ete);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onItemBreak(PlayerItemBreakEvent event) {
		BukkitMCItemBreakEvent ibe = new BukkitMCItemBreakEvent(event);
		EventUtils.TriggerListener(Driver.ITEM_BREAK, "item_break", ibe);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onItemMend(PlayerItemMendEvent event) {
		BukkitMCItemMendEvent ime = new BukkitMCItemMendEvent(event);
		EventUtils.TriggerListener(Driver.ITEM_MEND, "item_mend", ime);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onLocaleChange(PlayerLocaleChangeEvent event) {
		BukkitMCLocaleChangeEvent lce = new BukkitMCLocaleChangeEvent(event);
		EventUtils.TriggerListener(Driver.LOCALE_CHANGE, "locale_change", lce);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent event) {
		BukkitMCPlayerAdvancementDoneEvent pade = new BukkitMCPlayerAdvancementDoneEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_ADVANCEMENT_DONE, "player_advancement_done", pade);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerAnimation(PlayerAnimationEvent event) {
		BukkitMCPlayerAnimationEvent pae = new BukkitMCPlayerAnimationEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_ANIMATION, "player_animation", pae);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerBucketFill(PlayerBucketFillEvent event) {
		BukkitMCPlayerBucketFillEvent pbfe = new BukkitMCPlayerBucketFillEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_BUCKET, "player_bucket_fill", pbfe);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerBucket(PlayerBucketEmptyEvent event) {
		BukkitMCPlayerBucketEmptyEvent pbe = new BukkitMCPlayerBucketEmptyEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_BUCKET, "player_bucket_empty", pbe);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerResourcepackStatus(PlayerResourcePackStatusEvent event) {
		BukkitMCPlayerResourcepackStatusEvent prpse = new BukkitMCPlayerResourcepackStatusEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_RESOURCEPACK_STATUS, "player_resourcepack_status", prpse);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerStatisticIncrement(PlayerStatisticIncrementEvent event) {
		BukkitMCPlayerStatisticIncrementEvent psie = new BukkitMCPlayerStatisticIncrementEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_STATISTIC_INCREMENT, "player_statistic_increment", psie);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerVelocity(PlayerVelocityEvent event) {
		BukkitMCPlayerVelocityEvent pve = new BukkitMCPlayerVelocityEvent(event);
		EventUtils.TriggerListener(Driver.PLAYER_VELOCITY, "player_velocity", pve);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerChannel(PlayerChannelEvent event) {
		BukkitMCPlayerChannelEvent prce = new BukkitMCPlayerChannelEvent(event);
		if(event instanceof PlayerRegisterChannelEvent) {
			EventUtils.TriggerListener(Driver.PLAYER_CHANNEL, "player_register_channel", prce);
		} else if(event instanceof PlayerUnregisterChannelEvent) {
			EventUtils.TriggerListener(Driver.PLAYER_CHANNEL, "player_unregister_channel", prce);
		}
	}

	// Reset player_move lastLocations when player respawns or teleports
	@EventHandler(priority = EventPriority.MONITOR)
	public void onNewRespawnLocation(PlayerRespawnEvent event) {
		for(Integer i : PlayerEvents.GetThresholdList()) {
			PlayerEvents.GetLastLocations(i).put(event.getPlayer().getName(), new BukkitMCLocation(event.getRespawnLocation()));
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onNewTeleportLocation(PlayerTeleportEvent event) {
		if(event.getFrom().equals(event.getTo())) {
			return;
		}
		if(!event.isCancelled()) {
			for(Integer i : PlayerEvents.GetThresholdList()) {
				PlayerEvents.GetLastLocations(i).put(event.getPlayer().getName(), new BukkitMCLocation(event.getTo()));
			}
		}
	}
}
