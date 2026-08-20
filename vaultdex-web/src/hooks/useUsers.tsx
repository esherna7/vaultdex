import { useMutation, useQuery } from '@tanstack/react-query';
import { API_ROUTES } from '../api/api-config';
import axios from 'axios';

interface IRegisterUserPayload {
    username: string;
    email: string;
    password: string;
}

export interface CurrentUser {
    id: number;
    email: string;
    username: string;
    createdAt: string;
}

async function registerUser({ username, email, password }: IRegisterUserPayload) {
    try {
        const { data } = await axios.post(API_ROUTES.USER_REGISTER, {
            username,
            email,
            password
        });
        return data;
    } catch (error) {
        console.error("Failed to register user:", error);
        throw error;
    }
}

export const useRegisterUser = () => {
    return useMutation({
        mutationFn: registerUser,
        retry: 3,
    });
};

async function loginUser({ username, password }: { username: string, password: string }) {
    try {
        const { data } = await axios.post(API_ROUTES.USER_LOGIN, {
            username,
            password
        }, {
            withCredentials: true,
        });
        return data;
    } catch (error) {
        console.error("Failed to login user:", error);
        throw error;
    }
}

export const useLoginUser = () => {
    return useMutation({
        mutationFn: loginUser,
        // retry: 3,
    });
};

async function fetchCurrentUser() {
    const { data } = await axios.get<CurrentUser>('/api/users/me', {
        withCredentials: true,
    });
    return data;
}

export const useCurrentUser = () => {
    return useQuery({
        queryKey: ['currentUser'],
        queryFn: fetchCurrentUser,
        retry: false,
    });
};
