/*
 * Copyright (c) 2014 Cristian Vrabie, Evelina Vrabie.
 *
 * This file is part of android-deferred-object.
 * android-deferred-object is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License,or (at your option) any later version.
 *
 * android-deferred-object is distributed in the hope that it will be useful, butWITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with android-deferred-object.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.codeandmagic.deferredobject.tests;

import junit.framework.TestCase;
import org.codeandmagic.deferredobject.Callback;
import org.codeandmagic.deferredobject.Either;
import org.codeandmagic.deferredobject.Right;

import static org.mockito.Mockito.*;

/**
 * Created by cristian on 10/02/2014.
 */
public class CallbackTests extends TestCase {

    public void testCallbacks() {
        InspectableDeferredObject<Integer, Void, Void> promise = new InspectableDeferredObject<Integer, Void, Void>();
        Callback<Integer> onSuccess = mock(Callback.class);
        Callback<Either<Void, Integer>> onComplete = mock(Callback.class);

        promise.onSuccess(onSuccess).onComplete(onComplete);

        promise.success(3);

        verify(onSuccess, only()).onCallback(3);
        verify(onComplete, only()).onCallback(new Right<Void, Integer>(3));
    }
}
