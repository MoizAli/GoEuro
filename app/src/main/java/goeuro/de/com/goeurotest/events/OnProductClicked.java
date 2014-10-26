package goeuro.de.com.goeurotest.events;


import java.util.ArrayList;

import goeuro.de.com.goeurotest.entities.Location;

public final class OnProductClicked{


    protected OnProductClicked() {
    }

    public static final class ProductClick extends BaseEvent<ArrayList<Location>> {

        public ProductClick(final ArrayList<Location> content) {
            super(content);
        }
    }
}
