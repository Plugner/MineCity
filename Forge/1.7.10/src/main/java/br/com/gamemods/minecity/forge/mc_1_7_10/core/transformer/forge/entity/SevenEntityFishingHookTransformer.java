package br.com.gamemods.minecity.forge.mc_1_7_10.core.transformer.forge.entity;

import br.com.gamemods.minecity.forge.base.Referenced;
import br.com.gamemods.minecity.forge.base.core.transformer.forge.entity.EntityFishingHookTransformer;
import br.com.gamemods.minecity.forge.mc_1_7_10.core.MineCitySevenCoreMod;
import br.com.gamemods.minecity.forge.mc_1_7_10.protection.MineCitySevenHooks;
import net.minecraft.util.MovingObjectPosition;

@Referenced
public class SevenEntityFishingHookTransformer extends EntityFishingHookTransformer
{
    @Referenced(at = MineCitySevenCoreMod.class)
    public SevenEntityFishingHookTransformer()
    {
        super(MovingObjectPosition.class.getName(), MineCitySevenHooks.class.getName());
    }
}