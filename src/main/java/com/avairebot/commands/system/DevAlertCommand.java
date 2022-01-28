/*
 * Copyright (c) 2018.
 *
 * This file is part of AvaIre.
 *
 * AvaIre is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AvaIre is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AvaIre.  If not, see <https://www.gnu.org/licenses/>.
 *
 *
 */

package com.avairebot.commands.system;

import com.avairebot.AvaIre;
import com.avairebot.commands.CommandMessage;
import com.avairebot.contracts.commands.SystemCommand;
import net.dv8tion.jda.api.entities.Guild;

import java.util.Collections;
import java.util.List;

public class DevAlertCommand extends SystemCommand {

    public DevAlertCommand(AvaIre avaire) {
        super(avaire);
    }

    @Override
    public String getName() {
        return "Dev Announcement Command";
    }

    @Override
    public String getDescription() {
        return "Allows bot developers to announce things regarding bot development. [Dev+]";
    }

    @Override
    public List<String> getUsageInstructions() {
        return Collections.singletonList(
            "`:command <announcement>` - Sends the announcement to all alert channels."
        );
    }

    @Override
    public List<String> getExampleUsage() {
        return Collections.singletonList("`:command The bot is now undergoing a temporary shutdown.`");
    }


        try {
            let embed = new Discord.MessageEmbed();

        let msg = args.join(' ');
        if(!msg) {
            embed.setDescription(`Missing arguments.\n\nUsage: \`${client.config.prefix}${path.basename(__filename).split('.')[0]}${' ' + config.usage || ''}\``);
            embed.setColor(client.config.colors.error);
            embed.setAuthor(message.author.tag, message.author.displayAvatarURL());
            return message.channel.send(embed);
        }



        let alertChannel = await client.channels.fetch(`771371628243189791`);

        embed.setTitle('**Important Dev Announcement**')
        embed.setDescription(`The following message was sent on behalf of the Xenon administration team:\n\`\`\`${msg}\`\`\``);
        embed.setColor(client.config.colors.info);
        embed.setAuthor('Development Team','https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/Red_Circle%28small%29.svg/2048px-Red_Circle%28small%29.svg.png');
        alertChannel.send(embed);


        return true;
    }
}
