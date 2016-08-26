package br.com.gamemods.minecity.forge.base.protection;

import br.com.gamemods.minecity.MineCity;
import br.com.gamemods.minecity.api.command.Message;
import br.com.gamemods.minecity.api.permission.Permissible;
import br.com.gamemods.minecity.api.permission.PermissionFlag;
import br.com.gamemods.minecity.api.world.BlockPos;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.stream.Stream;

public class SingleBlockReaction implements Reaction
{
    @NotNull
    private BlockPos pos;

    @NotNull
    private PermissionFlag flag;

    public SingleBlockReaction(@NotNull BlockPos pos, @NotNull PermissionFlag flag)
    {
        this.pos = pos;
        this.flag = flag;
    }

    @Override
    public Stream<Message> stream(MineCity mineCity, Permissible permissible)
    {
        return Stream.generate(()-> can(mineCity, permissible)).filter(Optional::isPresent).map(Optional::get).limit(1);
    }

    @Override
    public Optional<Message> can(MineCity mineCity, Permissible permissible)
    {
        return mineCity.provideChunk(pos.getChunk()).getFlagHolder(pos).can(permissible, flag);
    }
}