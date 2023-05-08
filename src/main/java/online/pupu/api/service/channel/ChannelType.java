package online.pupu.api.service.channel;

public enum ChannelType {
    TEXT(1),
    VOICE(2);

    private final int value;

    ChannelType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
