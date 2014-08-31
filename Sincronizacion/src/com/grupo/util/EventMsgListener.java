package com.grupo.util;

import java.util.EventListener;

public abstract interface EventMsgListener extends EventListener
{
  public abstract void onMessage(EventMsg paramEventMsg);
}
