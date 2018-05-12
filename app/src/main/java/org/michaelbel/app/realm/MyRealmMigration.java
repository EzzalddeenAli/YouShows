package org.michaelbel.app.realm;

import android.support.annotation.NonNull;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

/**
 * Date: 22 APR 2018
 * Time: 09:56 MSK
 *
 * @author Michael Bel
 */

@SuppressWarnings("all")
public class MyRealmMigration implements RealmMigration {

    @Override
    public void migrate(@NonNull DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema realmSchema = realm.getSchema();

        if (oldVersion == 0) {
            RealmObjectSchema schema = realmSchema.get("Season");
            schema.addField("lastWatchDate", String.class);
            oldVersion++;
        }

        if (oldVersion == 1) {
            RealmObjectSchema schema = realmSchema.get("Show");
            schema.addField("progress", int.class);
            oldVersion++;
        }
    }
}