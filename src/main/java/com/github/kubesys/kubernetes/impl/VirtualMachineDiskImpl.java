/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.regex.Pattern;

import com.github.kubesys.kubernetes.api.model.VirtualMachineDisk;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDiskList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDiskSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CloneDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDiskFromDiskImage;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDiskInternalSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.DeleteDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.DeleteDiskInternalSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.ResizeDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.RevertDiskInternalSnapshot;
import com.github.kubesys.kubernetes.utils.RegExpUtils;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
public class VirtualMachineDiskImpl extends AbstractImpl<VirtualMachineDisk, VirtualMachineDiskList, VirtualMachineDiskSpec> {

	@Override
	public VirtualMachineDisk getModel() {
		return new VirtualMachineDisk();
	}

	@Override
	public VirtualMachineDiskSpec getSpec() {
		return new VirtualMachineDiskSpec();
	}
	

	@Override
	public Object getLifecycle() {
		return new Lifecycle();
	}


	@Override
	public VirtualMachineDiskSpec getSpec(VirtualMachineDisk r) {
		return r.getSpec();
	}

	/*************************************************
	 * 
	 * Generated by <code>MethodGenerator<code>
	 * 
	 **************************************************/
	public boolean deleteDisk(String name, DeleteDisk deleteDisk) throws Exception {
		return deleteDisk(name, deleteDisk, null);
	}

	public boolean deleteDisk(String name, DeleteDisk deleteDisk, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return delete(name, updateMetadata(name, eventId), deleteDisk);
	}

	public boolean deleteDisk(String name, String nodeName, DeleteDisk deleteDisk) throws Exception {
		updateHost(name, nodeName);
		return deleteDisk(name, deleteDisk, null);
	}

	public boolean deleteDisk(String name, String nodeName, DeleteDisk deleteDisk, String eventId) throws Exception {
		updateHost(name, nodeName);
		return deleteDisk(name, deleteDisk, eventId);
	}

	public boolean resizeDisk(String name, ResizeDisk resizeDisk) throws Exception {
		return resizeDisk(name, resizeDisk, null);
	}

	public boolean resizeDisk(String name, ResizeDisk resizeDisk, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), resizeDisk);
	}

	public boolean resizeDisk(String name, String nodeName, ResizeDisk resizeDisk) throws Exception {
		updateHost(name, nodeName);
		return resizeDisk(name, resizeDisk, null);
	}

	public boolean resizeDisk(String name, String nodeName, ResizeDisk resizeDisk, String eventId) throws Exception {
		updateHost(name, nodeName);
		return resizeDisk(name, resizeDisk, eventId);
	}

	public boolean createDisk(String name, CreateDisk createDisk) throws Exception {
		return createDisk(name, null, createDisk, null);
	}

	public boolean createDisk(String name, String nodeName, CreateDisk createDisk) throws Exception {
		return createDisk(name, nodeName, createDisk, null);
	}

	public boolean createDisk(String name, CreateDisk createDisk, String eventId) throws Exception {
		return createDisk(name, null, createDisk, eventId);
	}

	public boolean createDisk(String name, String nodeName,CreateDisk createDisk, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createDisk)));
	}

	public boolean createDiskFromDiskImage(String name, CreateDiskFromDiskImage createDiskFromDiskImage) throws Exception {
		return createDiskFromDiskImage(name, null, createDiskFromDiskImage, null);
	}

	public boolean createDiskFromDiskImage(String name, String nodeName, CreateDiskFromDiskImage createDiskFromDiskImage) throws Exception {
		return createDiskFromDiskImage(name, nodeName, createDiskFromDiskImage, null);
	}

	public boolean createDiskFromDiskImage(String name, CreateDiskFromDiskImage createDiskFromDiskImage, String eventId) throws Exception {
		return createDiskFromDiskImage(name, null, createDiskFromDiskImage, eventId);
	}

	public boolean createDiskFromDiskImage(String name, String nodeName,CreateDiskFromDiskImage createDiskFromDiskImage, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createDiskFromDiskImage)));
	}

	public boolean cloneDisk(String name, CloneDisk cloneDisk) throws Exception {
		return cloneDisk(name, cloneDisk, null);
	}

	public boolean cloneDisk(String name, CloneDisk cloneDisk, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), cloneDisk);
	}

	public boolean migrateDisk(String name, Lifecycle.MigrateDisk migrateDisk) throws Exception {
		return migrateDisk(name, migrateDisk, null);
	}

	public boolean migrateDisk(String name, Lifecycle.MigrateDisk migrateDisk, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), migrateDisk);
	}

	public boolean cloneDisk(String name, String nodeName, CloneDisk cloneDisk) throws Exception {
		updateHost(name, nodeName);
		return cloneDisk(name, cloneDisk, null);
	}

	public boolean cloneDisk(String name, String nodeName, CloneDisk cloneDisk, String eventId) throws Exception {
		updateHost(name, nodeName);
		return cloneDisk(name, cloneDisk, eventId);
	}

	public boolean createDiskInternalSnapshot(String name, CreateDiskInternalSnapshot createDiskInternalSnapshot) throws Exception {
		return createDiskInternalSnapshot(name, null, createDiskInternalSnapshot, null);
	}

	public boolean createDiskInternalSnapshot(String name, String nodeName, CreateDiskInternalSnapshot createDiskInternalSnapshot) throws Exception {
		return createDiskInternalSnapshot(name, nodeName, createDiskInternalSnapshot, null);
	}

	public boolean createDiskInternalSnapshot(String name, CreateDiskInternalSnapshot createDiskInternalSnapshot, String eventId) throws Exception {
		return createDiskInternalSnapshot(name, null, createDiskInternalSnapshot, eventId);
	}

	public boolean createDiskInternalSnapshot(String name, String nodeName,CreateDiskInternalSnapshot createDiskInternalSnapshot, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createDiskInternalSnapshot)));
	}

	public boolean revertDiskInternalSnapshot(String name, RevertDiskInternalSnapshot revertDiskInternalSnapshot) throws Exception {
		return revertDiskInternalSnapshot(name, revertDiskInternalSnapshot, null);
	}

	public boolean revertDiskInternalSnapshot(String name, RevertDiskInternalSnapshot revertDiskInternalSnapshot, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), revertDiskInternalSnapshot);
	}

	public boolean revertDiskInternalSnapshot(String name, String nodeName, RevertDiskInternalSnapshot revertDiskInternalSnapshot) throws Exception {
		updateHost(name, nodeName);
		return revertDiskInternalSnapshot(name, revertDiskInternalSnapshot, null);
	}

	public boolean revertDiskInternalSnapshot(String name, String nodeName, RevertDiskInternalSnapshot revertDiskInternalSnapshot, String eventId) throws Exception {
		updateHost(name, nodeName);
		return revertDiskInternalSnapshot(name, revertDiskInternalSnapshot, eventId);
	}

	public boolean deleteDiskInternalSnapshot(String name, DeleteDiskInternalSnapshot deleteDiskInternalSnapshot) throws Exception {
		return deleteDiskInternalSnapshot(name, deleteDiskInternalSnapshot, null);
	}

	public boolean deleteDiskInternalSnapshot(String name, DeleteDiskInternalSnapshot deleteDiskInternalSnapshot, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return delete(name, updateMetadata(name, eventId), deleteDiskInternalSnapshot);
	}

	public boolean deleteDiskInternalSnapshot(String name, String nodeName, DeleteDiskInternalSnapshot deleteDiskInternalSnapshot) throws Exception {
		updateHost(name, nodeName);
		return deleteDiskInternalSnapshot(name, deleteDiskInternalSnapshot, null);
	}

	public boolean deleteDiskInternalSnapshot(String name, String nodeName, DeleteDiskInternalSnapshot deleteDiskInternalSnapshot, String eventId) throws Exception {
		updateHost(name, nodeName);
		return deleteDiskInternalSnapshot(name, deleteDiskInternalSnapshot, eventId);
	}

	public boolean backupDisk(String name, Lifecycle.BackupDisk backupDisk) throws Exception {
		return backupDisk(name, backupDisk, null);
	}

	public boolean backupDisk(String name, Lifecycle.BackupDisk backupDisk, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return delete(name, updateMetadata(name, eventId), backupDisk);
	}

	public boolean backupDisk(String name, String nodeName, Lifecycle.BackupDisk backupDisk) throws Exception {
		updateHost(name, nodeName);
		return backupDisk(name, backupDisk, null);
	}

	public boolean backupDisk(String name, String nodeName, Lifecycle.BackupDisk backupDisk, String eventId) throws Exception {
		updateHost(name, nodeName);
		return backupDisk(name, backupDisk, eventId);
	}

	//
	public boolean restoreDisk(String name, Lifecycle.RestoreDisk restoreDisk) throws Exception {
		return restoreDisk(name, restoreDisk, null);
	}

	public boolean restoreDisk(String name, Lifecycle.RestoreDisk restoreDisk, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return delete(name, updateMetadata(name, eventId), restoreDisk);
	}

	public boolean restoreDisk(String name, String nodeName, Lifecycle.RestoreDisk restoreDisk) throws Exception {
		updateHost(name, nodeName);
		return restoreDisk(name, restoreDisk, null);
	}

	public boolean restoreDisk(String name, String nodeName, Lifecycle.BackupDisk restoreDisk, String eventId) throws Exception {
		updateHost(name, nodeName);
		return backupDisk(name, restoreDisk, eventId);
	}
}
