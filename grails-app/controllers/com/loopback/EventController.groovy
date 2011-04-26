package com.loopback

class EventController {

    def index = {
        def events = Event.list()
        [events:events]
    }

    def add = {
    }

    def show = {
        def event = Event.get(params.id)
        [event:event]
    }
}
