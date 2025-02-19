package plugin.items

import com.asteria.game.GameConstants
import com.asteria.game.character.player.Player
import com.asteria.game.item.Item
import com.asteria.game.plugin.PluginListener
import com.asteria.game.plugin.PluginSignature
import com.asteria.game.plugin.context.ItemFirstClickPlugin
import com.asteria.utility.RandomGen

@PluginSignature(ItemFirstClickPlugin.class)
final class ItemFirstClick implements PluginListener<ItemFirstClickPlugin> {

    @Override
    void execute(Player player, ItemFirstClickPlugin context) {
        switch (context.item.id) {
            case 405:
                Item item = new RandomGen().random GameConstants.CASKET_ITEMS
                if (player.inventory.add(item.copy())) {
                    player.inventory.remove(new Item(405), context.slot)
                    player.messages.sendMessage "You open the casket and recieve an item!"
                }
                break
        }
    }
}
