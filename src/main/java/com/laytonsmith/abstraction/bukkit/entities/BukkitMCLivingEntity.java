package com.laytonsmith.abstraction.bukkit.entities;

import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.MCEntityEquipment;
import com.laytonsmith.abstraction.MCLivingEntity;
import com.laytonsmith.abstraction.MCLocation;
import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.abstraction.blocks.MCBlock;
import com.laytonsmith.abstraction.bukkit.BukkitConvertor;
import com.laytonsmith.abstraction.bukkit.BukkitMCEntityEquipment;
import com.laytonsmith.abstraction.bukkit.BukkitMCLocation;
import com.laytonsmith.abstraction.bukkit.blocks.BukkitMCBlock;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.exceptions.CRE.CREBadEntityException;
import org.bukkit.block.Block;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BlockIterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class BukkitMCLivingEntity extends BukkitMCEntityProjectileSource implements MCLivingEntity {

	LivingEntity le;

	public BukkitMCLivingEntity(Entity ent) {
		super(ent);
		this.le = (LivingEntity) ent;
	}

	@Override
	public double getHealth() {
		return le.getHealth();
	}

	@Override
	public void setHealth(double i) {
		le.setHealth(i);
	}

	@Override
	public double getMaxHealth() {
		// Deprecated in 1.11
		return le.getMaxHealth();
	}

	@Override
	public void setMaxHealth(double health) {
		// Deprecated in 1.11
		le.setMaxHealth(health);
	}

	@Override
	public void resetMaxHealth() {
		// Deprecated in 1.11
		le.resetMaxHealth();
	}

	@Override
	public void damage(double i) {
		le.damage(i);
	}

	@Override
	public void damage(double amount, MCEntity source) {
		le.damage(amount, ((BukkitMCEntity) source).getHandle());
	}

	@Override
	public double getEyeHeight() {
		return le.getEyeHeight();
	}

	@Override
	public double getEyeHeight(boolean ignoreSneaking) {
		return le.getEyeHeight(ignoreSneaking);
	}

	@Override
	public MCLocation getEyeLocation() {
		return new BukkitMCLocation(le.getEyeLocation());
	}

	@Override
	public MCPlayer getKiller() {
		return new BukkitMCPlayer(le.getKiller());
	}

	@Override
	public double getLastDamage() {
		return le.getLastDamage();
	}

	@Override
	public MCBlock getTargetSpace(int maxDistance) {
		List<Block> lst = getLineOfSight(null, maxDistance, 2);
		return new BukkitMCBlock(lst.get(0));
	}

	@Override
	public List<MCBlock> getLineOfSight(HashSet<Short> transparent, int maxDistance) {
		List<Block> lst = getLineOfSight(transparent, maxDistance, 512);
		List<MCBlock> retn = new ArrayList<>();

		for(Block b : lst) {
			retn.add(new BukkitMCBlock(b));
		}

		return retn;
	}

	private List<Block> getLineOfSight(HashSet<Short> transparent, int maxDistance, int maxLength) {
		if(maxDistance > 512) {
			maxDistance = 512;
		}
		ArrayList<Block> blocks = new ArrayList<>();
		Iterator<Block> itr = new BlockIterator(le, maxDistance);

		while(itr.hasNext()) {
			Block block = itr.next();
			blocks.add(block);
			if(maxLength != 0 && blocks.size() > maxLength) {
				blocks.remove(0);
			}
			int id = block.getTypeId();
			if(transparent == null) {
				if(id != 0) {
					break;
				}
			} else {
				if(!transparent.contains((short) id)) {
					break;
				}
			}
		}
		return blocks;
	}

	@Override
	public boolean hasLineOfSight(MCEntity other) {
		return le.hasLineOfSight(((BukkitMCEntity) other).getHandle());
	}

	@Override
	public int getMaximumAir() {
		return le.getMaximumAir();
	}

	@Override
	public int getMaximumNoDamageTicks() {
		return le.getMaximumNoDamageTicks();
	}

	@Override
	public int getNoDamageTicks() {
		return le.getNoDamageTicks();
	}

	@Override
	public int getRemainingAir() {
		return le.getRemainingAir();
	}

	@Override
	public MCBlock getTargetBlock(HashSet<Short> b, int i) {
		return new BukkitMCBlock(getFirstTargetBlock(b, i));
	}

	private Block getFirstTargetBlock(HashSet<Short> transparent, int maxDistance) {
		List<Block> blocks = getLineOfSight(transparent, maxDistance, 1);
		return blocks.get(0);
	}

	@Override
	public boolean hasAI() {
		return le.hasAI();
	}

	@Override
	public void addEffect(int id, int strength, int ticks, boolean ambient, boolean particles, boolean icon) {
		PotionEffectType type = PotionEffectType.getById(id);
		PotionEffect pe = new PotionEffect(type, ticks, strength, ambient, particles, icon);
		le.addPotionEffect(pe, true);
	}

	@Override
	public int getMaxEffect() {
		return PotionEffectType.values().length - 1;
	}

	@Override
	public boolean removeEffect(int potionID) {
		PotionEffectType t = PotionEffectType.getById(potionID);
		boolean hasIt = false;
		for(PotionEffect pe : le.getActivePotionEffects()) {
			if(pe.getType() == t) {
				hasIt = true;
				break;
			}
		}
		le.removePotionEffect(t);
		return hasIt;
	}

	@Override
	public void removeEffects() {
		for(PotionEffect pe : le.getActivePotionEffects()) {
			le.removePotionEffect(pe.getType());
		}
	}

	@Override
	public List<MCEffect> getEffects() {
		List<MCEffect> effects = new ArrayList<>();
		for(PotionEffect pe : le.getActivePotionEffects()) {
			MCEffect e = new MCEffect(pe.getType().getId(), pe.getAmplifier(), pe.getDuration(), pe.isAmbient(),
					pe.hasParticles(), pe.hasIcon());
			effects.add(e);
		}
		return effects;
	}

	@Override
	public void setLastDamage(double damage) {
		le.setLastDamage(damage);
	}

	@Override
	public void setMaximumAir(int ticks) {
		le.setMaximumAir(ticks);
	}

	@Override
	public void setMaximumNoDamageTicks(int ticks) {
		le.setMaximumNoDamageTicks(ticks);
	}

	@Override
	public void setNoDamageTicks(int ticks) {
		le.setNoDamageTicks(ticks);
	}

	@Override
	public void setRemainingAir(int ticks) {
		le.setRemainingAir(ticks);
	}

	public LivingEntity asLivingEntity() {
		return le;
	}

	@Override
	public MCEntityEquipment getEquipment() {
		if(le.getEquipment() == null) {
			return null;
		}
		return new BukkitMCEntityEquipment(le.getEquipment());
	}

	@Override
	public boolean getCanPickupItems() {
		return le.getCanPickupItems();
	}

	@Override
	public void setCanPickupItems(boolean pickup) {
		le.setCanPickupItems(pickup);
	}

	@Override
	public boolean getRemoveWhenFarAway() {
		return le.getRemoveWhenFarAway();
	}

	@Override
	public void setRemoveWhenFarAway(boolean remove) {
		le.setRemoveWhenFarAway(remove);
	}

	@Override
	public MCLivingEntity getTarget(Target t) {
		if(!(le instanceof Creature)) {
			throw new CREBadEntityException("This type of mob does not have a target API", t);
		}
		LivingEntity target = ((Creature) le).getTarget();
		if(target == null) {
			return null;
		}
		return new BukkitMCLivingEntity(target);
	}

	@Override
	public void setTarget(MCLivingEntity target, Target t) {
		if(!(le instanceof Creature)) {
			throw new CREBadEntityException("This type of mob does not have a target API", t);
		}
		if(target == null) {
			((Creature) le).setTarget(null);
		} else {
			((Creature) le).setTarget(((BukkitMCLivingEntity) target).asLivingEntity());
		}
	}

	@Override
	public void kill() {
		le.setLastDamageCause(new EntityDamageEvent(le, EntityDamageEvent.DamageCause.CUSTOM, le.getHealth()));
		le.setHealth(0D);
	}

	@Override
	public MCEntity getLeashHolder() {
		if(le.isLeashed()) {
			return BukkitConvertor.BukkitGetCorrectEntity(le.getLeashHolder());
		}
		return null;
	}

	@Override
	public boolean isLeashed() {
		return le.isLeashed();
	}

	@Override
	public void setLeashHolder(MCEntity holder) {
		if(holder == null) {
			le.setLeashHolder(null);
		} else {
			le.setLeashHolder(((BukkitMCEntity) holder).getHandle());
		}
	}

	@Override
	public boolean isGliding() {
		return le.isGliding();
	}

	@Override
	public void setGliding(Boolean glide) {
		le.setGliding(glide);
	}

	@Override
	public void setAI(Boolean ai) {
		le.setAI(ai);
	}
}
