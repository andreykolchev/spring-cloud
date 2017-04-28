package app.scalingpolicy;

import java.util.Map;

public interface ScalingPolicy {

    boolean execute(String serviceId, Map metrics);

}