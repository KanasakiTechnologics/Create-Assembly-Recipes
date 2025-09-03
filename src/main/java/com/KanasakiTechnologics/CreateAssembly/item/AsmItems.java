package com.KanasakiTechnologics.CreateAssembly.item;

import com.KanasakiTechnologics.CreateAssembly.CreateAssembly;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AsmItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateAssembly.MOD_ID);
    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}
}
