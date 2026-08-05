import { Navigate, Route, Routes, useLocation } from 'react-router-dom';
import './App.css';
import RegisterUser from './pages/RegisterUser';
import 'react-toastify/dist/ReactToastify.css';
import Login from './pages/Login';
import Dashboard from './pages/Dashboard';
import SetDetailsPage from './pages/SetDetailsPage';
import { type ReactNode } from 'react';
import HeaderBar from './components/header/HeaderBar';

const isAuthenticated = () => typeof window !== 'undefined' && localStorage.getItem('isAuthenticated') === 'true';

function ProtectedRoute({ children }: { children: ReactNode }) {
  const location = useLocation();

  if (!isAuthenticated()) {
    return <Navigate to="/login" replace state={{ from: location }} />;
  }

  return <>{children}</>;
}

function onVaultDexLogoClick() {
  if (isAuthenticated()) {
    window.location.href = '/dashboard';
  } else {
    window.location.href = '/login';
  }
}

function App() {
  return (
    <>
      <HeaderBar onVaultDexLogoClick={onVaultDexLogoClick} />
      <Routes>
        <Route path="/" element={isAuthenticated() ? <Navigate to="/dashboard" replace /> : <Navigate to="/login" replace />} />
        <Route path="/register" element={<RegisterUser />} />
        <Route path="/login" element={isAuthenticated() ? <Navigate to="/dashboard" replace /> : <Login />} />
        <Route path="/dashboard" element={<ProtectedRoute><Dashboard /></ProtectedRoute>} />
        <Route path="/sets/:setId" element={<ProtectedRoute><SetDetailsPage setId={useLocation().pathname.split('/sets/')[1]} /></ProtectedRoute>} />
      </Routes>
    </>
  );
}

export default App
