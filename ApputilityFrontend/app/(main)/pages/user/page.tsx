/* eslint-disable @next/next/no-img-element */
'use client';
import { Button } from 'primereact/button';
import { Column } from 'primereact/column';
import { DataTable } from 'primereact/datatable';
import { Dialog } from 'primereact/dialog';
import { FileUpload } from 'primereact/fileupload';
import { InputNumber, InputNumberValueChangeEvent } from 'primereact/inputnumber';
import { InputText } from 'primereact/inputtext';
import { InputTextarea } from 'primereact/inputtextarea';
import { RadioButton, RadioButtonChangeEvent } from 'primereact/radiobutton';
import { Rating } from 'primereact/rating';
import { Toast } from 'primereact/toast';
import { Toolbar } from 'primereact/toolbar';
import { classNames } from 'primereact/utils';
import React, { useEffect, useRef, useState } from 'react';
import { ProductService } from '../../../../demo/service/ProductService';
import { UserService } from 'service/UserService';
import { Project } from '@/types';

/* @todo Used 'as any' for types here. Will fix in next version due to onSelectionChange event type issue. */
const Crud = () => {
    let emptyUser: Project.User = {
        id: 0,
        name: '',
        loginName: '',
        email: '',
        passwd: ''
    };

    const [users, setUsers] = useState<Project.User[]>([]);
    const [userDialog, setUserDialog] = useState(false);
    const [deleteUserDialog, setDeleteUserDialog] = useState(false);
    const [deleteUsersDialog, setDeleteUsersDialog] = useState(false);
    const [user, setUser] = useState<Project.User>(emptyUser);
    const [selectedUsers, setSelectedUsers] = useState(null);
    const [submitted, setSubmitted] = useState(false);
    const [globalFilter, setGlobalFilter] = useState('');
    const toast = useRef<Toast>(null);
    const dt = useRef<DataTable<any>>(null);
    const userService = new UserService();

    useEffect(() => {
        if(users.length ==0 ){
            userService.getAllUsers()
            .then((response) => {
                console.log(response.data);
                setUsers(response.data);
            })
            .catch((error) => {
                console.log(error);
            });

        }
    }, [users]);

    const openNew = () => {
        setUser(emptyUser);
        setSubmitted(false);
        setUserDialog(true);
    };

    const hideDialog = () => {
        setSubmitted(false);
        setUserDialog(false);
    };

    const hideDeleteUserDialog = () => {
        setDeleteUserDialog(false);
    };

    const hideDeleteUsersDialog = () => {
        setDeleteUsersDialog(false);
    };

    const saveUser = () => {
        setSubmitted(true);

        // TODO: Validation
        if (!user.id) {
            userService.saveUser(user).then((response) => {
                console.log(response.data);
                setUserDialog(false);// se o usuário foi criado, o dialogo será fechado.
                setUser(emptyUser); // Limpa o formulário.
                setUsers([]);
                toast.current.show({ severity: 'info', summary: 'Successo', detail: 'Utilizador criado com sucesso!' });// Se o usuário não foi criado, o toast será fechado.
            }).catch((error) => {
                console.log(error.data.message);
                toast.current.show({ severity: 'error', summary: 'Error', detail: 'Erro ao criar utilizador! ' + error.data.message });
            });
        } else {
            userService.updateUser(user).then((response) => {
                console.log(response.data);
                setUserDialog(false);// se o utilizador foi atualizado, o dialogo será fechado.
                setUsers([]);
                toast.current.show({ severity: 'info', summary: 'Successo', detail: 'Utilizador atualizado com sucesso!' });// Se o utilizador não foi atualizado, o toast será fechado.
            }).catch((error) => {
                console.log(error.data.message);
                toast.current.show({ severity: 'error', summary: 'Error', detail: 'Erro ao atualizar utilizador!'+ error.data.message });
            });
        }
        
    }; 

    const editUser = (user: Project.user) => {
        setUser({ ...user });
        setUserDialog(true);
    };

    const confirmDeleteUser = (user: Project.user) => {
        setUser(user);
        setDeleteUserDialog(true);
    };

    const deleteUser = () => {
            userService.deleteUser(user.id).then((response) => { 
            setUser(emptyUser); // Limpa o formulário.    
            setUsers([]);           
            setDeleteUserDialog(false);// se o usuário foi eliminado, o dialogo será fechado.            
            toast.current?.show({ severity: 'success', summary: 'Successo!', detail: 'Utilizador eliminado com sucesso!', life:3000 }); // Se o utilizador não foi excluído, o toast será fechado.
            
        }).catch((error) => {
            console.log(error.data.message);
            toast.current.show({ severity: 'error', summary: 'Erro!', detail: 'Erro ao eliminar utilizador!'+ error.data.message, life: 3000 }); // Se o utilizador não foi excluído, o toast será fechado.
        }); 
        /* let _users = (users as any)?.filter((val: any) => val.id !== user.id);
        setUsers(_users);
        setDeleteUserDialog(false);
        setUser(emptyUser);
        toast.current?.show({
            severity: 'success',
            summary: 'Successful',
            detail: 'User Deleted',
            life: 3000
        }).catch((error) => {
            console.log(error.data.message);
            toast.current.show({ severity: 'error', summary: 'Erro!', detail: 'Erro ao eliminar utilizador!'+ error.data.message, life: 3000 });
        });  */
    };

    /* const findIndexById = (id: string) => {
        let index = -1;
        for (let i = 0; i < (users as any)?.length; i++) {
            if ((users as any)[i].id === id) {
                index = i;
                break;
            }
        }

        return index;
    };

    const createId = () => {
        let id = '';
        let chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        for (let i = 0; i < 5; i++) {
            id += chars.charAt(Math.floor(Math.random() * chars.length));
        }
        return id;
    };
 */
    const exportCSV = () => {
        dt.current?.exportCSV();
    };

    const confirmDeleteSelected = () => {
        setDeleteUsersDialog(true);
    };

    const deleteSelectedUsers = () => {
        /* let _products = (products as any)?.filter((val: any) => !(selectedProducts as any)?.includes(val));
        setProducts(_products);
        setDeleteProductsDialog(false);
        setSelectedProducts(null);
        toast.current?.show({
            severity: 'success',
            summary: 'Successful',
            detail: 'Products Deleted',
            life: 3000
        }); */
    };

    /* const onCategoryChange = (e: RadioButtonChangeEvent) => {
        let _product = { ...product };
        _product['category'] = e.value;
        setProduct(_product);
    };*/

    const onInputChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>, name: string) => {
        const val = (e.target && e.target.value) || '';
        let _user = { ...user };
        _user[`${name}`] = val;

        setUser(_user);
    };

    /* const onInputNumberChange = (e: InputNumberValueChangeEvent, name: string) => {
        const val = e.value || 0;
        let _user = { ...user };
        _user[`${name}`] = val;

        setUser(_user);
    }; */ 

    const leftToolbarTemplate = () => {
        return (
            <React.Fragment>
                <div className="my-2">
                    <Button label="Novo" icon="pi pi-plus" severity="success" className=" mr-2" onClick={openNew} />
                    <Button label="Apagar" icon="pi pi-trash" severity="danger" onClick={confirmDeleteSelected} disabled={!selectedUsers || !(selectedUsers as any).length} />
                </div>
            </React.Fragment>
        );
    };

    const rightToolbarTemplate = () => {
        return (
            <React.Fragment>
                <FileUpload mode="basic" accept="image/*" maxFileSize={1000000} chooseLabel="Import" className="mr-2 inline-block" />
                <Button label="Export" icon="pi pi-upload" severity="help" onClick={exportCSV} />
            </React.Fragment>
        );
    };

    const idBodyTemplate = (rowData: Project.User) => {
        return (
            <>
                <span className="p-column-title">Código</span>
                {rowData.id}
            </>
        );
    };

    const nameBodyTemplate = (rowData: Project.User) => {
        return (
            <>
                <span className="p-column-title">Nome</span>
                {rowData.name}
            </>
        );
    };

    const actionBodyTemplate = (rowData: Project.User) => {
        return (
            <>
                <Button icon="pi pi-pencil" rounded severity="success" className="mr-2" onClick={() => editUser(rowData)} />
                <Button icon="pi pi-trash" rounded severity="warning" onClick={() => confirmDeleteUser(rowData)} />
            </>
        );
    };

    const loginNameBodyTemplate = (rowData: Project.User) => {
        return (
            <>
                <span className="p-column-title">Login</span>
                {rowData.loginName}
            </>
        );
    };

    const emailBodyTemplate = (rowData: Project.User) => {
        return (
            <>
                <span className="p-column-title">Email</span>
                {rowData.email}
            </>
        );
    };

    /* const imageBodyTemplate = (rowData: Project.User) => {
        return (
            <>
                <span className="p-column-title">Image</span>
                <img src={`/demo/images/product/${rowData.image}`} alt={rowData.image} className="shadow-2" width="100" />
            </>
        );
    }; */


    const header = (
        <div className="flex flex-column md:flex-row md:justify-content-between md:align-items-center">
            <h5 className="m-0">Gestão de Utilizadores</h5>
            <span className="block mt-2 md:mt-0 p-input-icon-left">
                <i className="pi pi-search" />
                <InputText type="search" onInput={(e) => setGlobalFilter(e.currentTarget.value)} placeholder="Buscar..." />
            </span>
        </div>
    );

    const userDialogFooter = (
        <>
            <Button label="Cancelar" icon="pi pi-times" text onClick={hideDialog} />
            <Button label="Guardar" icon="pi pi-check" text onClick={saveUser} />
        </>
    );
    const deleteUserDialogFooter = (
        <>
            <Button label="Sim" icon="pi pi-times" text onClick={hideDeleteUserDialog} />
            <Button label="Não" icon="pi pi-check" text onClick={deleteUser} />
        </>
    );
    const deleteUsersDialogFooter = (
        <>
            <Button label="Não" icon="pi pi-times" text onClick={hideDeleteUsersDialog} />
            <Button label="Sim" icon="pi pi-check" text onClick={deleteSelectedUsers} />
        </>
    );

    return (
        <div className="grid crud-demo">
            <div className="col-12">
                <div className="card">
                    <Toast ref={toast} />
                    <Toolbar className="mb-4" left={leftToolbarTemplate} right={rightToolbarTemplate}></Toolbar>

                    <DataTable
                        ref={dt}
                        value={users}
                        selection={selectedUsers}
                        onSelectionChange={(e) => setSelectedUsers(e.value as any)}
                        dataKey="id"
                        paginator
                        rows={10}
                        rowsPerPageOptions={[5, 10, 25]}
                        className="datatable-responsive"
                        paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
                        currentPageReportTemplate="Mostra {first} a {last} de {totalRecords} Utilizadores"
                        globalFilter={globalFilter}
                        emptyMessage="Nenhum utilizador encontrado."
                        header={header}
                        responsiveLayout="scroll">
                        <Column selectionMode="multiple" headerStyle={{ width: '4rem' }}></Column>
                        <Column field="id" header="Código" sortable body={idBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        <Column field="name" header="Nome" sortable body={nameBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        <Column field="loginName" header="Login" sortable body={loginNameBodyTemplate} headerStyle={{ minWidth: '15rem'}}></Column>
                        <Column field="email" header="Email" sortable body={emailBodyTemplate} headerStyle={{ minWidth: '15rem' }}></Column>
                        {/* <Column field="rating" header="Reviews" body={ratingBodyTemplate} sortable></Column>
                        <Column field="inventoryStatus" header="Status" body={statusBodyTemplate} sortable headerStyle={{ minWidth: '10rem' }}></Column>
                        <Column header="Image" body={imageBodyTemplate}></Column> */} 
                        <Column body={actionBodyTemplate} headerStyle={{ minWidth: '10rem' }}></Column>
                    </DataTable>

                    <Dialog visible={userDialog} style={{ width: '450px' }} header="Detalhes do Utilizador" modal className="p-fluid" footer={userDialogFooter} onHide={hideDialog}>
                        {/* {product.image && <img src={`/demo/images/product/${product.image}`} alt={product.image} width="150" className="mt-0 mx-auto mb-5 block shadow-2" />} */}
                        <div className="field">
                            <label htmlFor="name">Nome</label>
                            <InputText
                                id="name"
                                value={user.name}
                                onChange={(e) => onInputChange(e, 'name')}
                                required
                                autoFocus
                                className={classNames({
                                    'p-invalid': submitted && !user.name
                                })}
                            />
                            {submitted && !user.name && <small className="p-invalid">O Nome é obrigatório.</small>}
                        </div>
                          

                        <div className="field">
                            <label htmlFor="loginName">Login</label>
                            <InputText
                                id="loginName"
                                value={user.loginName}
                                onChange={(e) => onInputChange(e, 'loginName')}
                                required
                                autoFocus
                                className={classNames({
                                    'p-invalid': submitted && !user.loginName
                                })}
                            />
                            {submitted && !user.loginName && <small className="p-invalid">O Login é obrigatório.</small>}
                        </div>
                        <div className="field">
                            <label htmlFor="email">Email</label>
                            <InputText
                                id="email"
                                value={user.name}
                                onChange={(e) => onInputChange(e, 'email')}
                                required
                                autoFocus
                                className={classNames({
                                    'p-invalid': submitted && !user.email
                                })}
                            />
                            {submitted && !user.email && <small className="p-invalid">O Email é obrigatório.</small>}
                        </div>
                        <div className="field">
                            <label htmlFor="passwd">Password</label>
                            <InputText
                                id="passwd"
                                value={user.passwd}
                                onChange={(e) => onInputChange(e, 'passwd')}
                                required
                                autoFocus
                                className={classNames({
                                    'p-invalid': submitted && !user.passwd
                                })}
                            />
                            {submitted && !user.passwd && <small className="p-invalid">A Password é obrigatória.</small>}
                        </div>
                    </Dialog>

                    <Dialog visible={deleteUserDialog} style={{ width: '450px' }} header="Confirmar" modal footer={deleteUserDialogFooter} onHide={hideDeleteUserDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {user && (
                                <span>
                                    Você tem a certeza que pretende eliminar o utilizador <b>{user.name}</b>?
                                </span>
                            )}
                        </div>
                    </Dialog>

                    <Dialog visible={deleteUsersDialog} style={{ width: '450px' }} header="Confirm" modal footer={deleteUsersDialogFooter} onHide={hideDeleteUsersDialog}>
                        <div className="flex align-items-center justify-content-center">
                            <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                            {user && <span>Você tem a certeza que pretende eliminar o utilizadores selecionados?</span>}
                        </div>
                    </Dialog>
                </div>
            </div>
        </div>
    );
};

export default Crud;
