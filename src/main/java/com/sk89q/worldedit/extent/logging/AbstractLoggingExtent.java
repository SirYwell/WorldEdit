/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.extent.logging;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.blocks.BaseBlock;
import com.sk89q.worldedit.extent.AbstractDelegateExtent;
import com.sk89q.worldedit.extent.Extent;

/**
 * An abstract class to implement block loggers and so on with.
 */
public abstract class AbstractLoggingExtent extends AbstractDelegateExtent<Extent> {

    /**
     * Create a new instance.
     *
     * @param extent the extent
     */
    protected AbstractLoggingExtent(Extent extent) {
        super(extent);
    }

    /**
     * Called when a block is being changed.
     *
     * @param position the position
     * @param newBlock the new block to replace the old one
     */
    protected void onBlockChange(Vector position, BaseBlock newBlock) {
    }

    @Override
    public final boolean setBlock(Vector position, BaseBlock block) throws WorldEditException {
        onBlockChange(position, block);
        return super.setBlock(position, block);
    }
    
}