var subscriptions = {}

function refreshComentSubsriptions(channels, callbackFunctions) {
    for (var i in channels) {
        if (typeof channels[i] == 'string') {
            unsubscribeFromChannel(channels[i]);
            subscribeToCometChannel(channels[i], callbackFunctions[channels[i]]);
        }
    }
}

function unsubscribeFromChannel(channel) {
    if (subscriptions[channel]) {
        $.cometd.unsubscribe(subscriptions[channel]);
    }

    subscriptions[channel] = null;
}

function subscribeToCometChannel(channel, callbackFunction) {
    subscriptions[channel] = $.cometd.subscribe(channel, callbackFunction);
}

